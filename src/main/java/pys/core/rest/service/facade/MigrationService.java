package pys.core.rest.service.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pys.core.rest.extern.client.common.ArticuloAliasClient;
import pys.core.rest.extern.client.common.ArticuloClient;
import pys.core.rest.extern.client.common.CotizacionClient;
import pys.core.rest.extern.client.common.ProveedorClient;
import pys.core.rest.extern.model.ArticuloAliasDto;
import pys.core.rest.extern.model.CotizacionDto;
import pys.core.rest.extern.model.ProveedorDto;
import pys.core.rest.kotlin.model.Articulo;
import pys.core.rest.extern.model.ArticuloDto;
import pys.core.rest.kotlin.model.ArticuloAlias;
import pys.core.rest.kotlin.model.Cotizacion;
import pys.core.rest.kotlin.model.Proveedor;
import pys.core.rest.service.ArticuloAliasService;
import pys.core.rest.service.ArticuloService;
import pys.core.rest.service.CotizacionService;
import pys.core.rest.service.ProveedorService;

import java.time.ZoneOffset;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MigrationService {

    private final CotizacionService cotizacionService;
    private final CotizacionClient cotizacionClient;
    private final ProveedorService proveedorService;
    private final ProveedorClient proveedorClient;
    private final ArticuloService articuloService;
    private final ArticuloClient articuloClient;
    private final ArticuloAliasService articuloAliasService;
    private final ArticuloAliasClient articuloAliasClient;

    public MigrationService(CotizacionService cotizacionService,
                            CotizacionClient cotizacionClient,
                            ProveedorService proveedorService,
                            ProveedorClient proveedorClient,
                            ArticuloService articuloService,
                            ArticuloClient articuloClient,
                            ArticuloAliasService articuloAliasService,
                            ArticuloAliasClient articuloAliasClient) {
        this.cotizacionService = cotizacionService;
        this.cotizacionClient = cotizacionClient;
        this.proveedorService = proveedorService;
        this.proveedorClient = proveedorClient;
        this.articuloService = articuloService;
        this.articuloClient = articuloClient;
        this.articuloAliasService = articuloAliasService;
        this.articuloAliasClient = articuloAliasClient;
    }

    public void migrate() {
        log.debug("Processing request for migrate");

        // Procesar cotizaciones en lotes para mejor rendimiento
        List<Cotizacion> cotizaciones = cotizacionService.findAll();
        log.debug("Found {} cotizaciones to migrate", cotizaciones.size());
        cotizaciones.parallelStream()
                .map(cotizacion -> {
                    log.debug("Migrating cotizacion");
                    logCotizacion(cotizacion);
                    return cotizacionConvertToDto(cotizacion);
                })
                .forEach(cotizacionDto -> {
                    CotizacionDto updatedDto = cotizacionClient.addOrUpdate(cotizacionDto);
                    logCotizacionDto(updatedDto);
                });

        var commonCotizaciones = cotizacionClient.findAll();

        Map<OffsetDateTime, Cotizacion> cotizacionesMap = cotizaciones.stream()
                .filter(c -> c.getFecha() != null)
                .collect(Collectors.toMap(
                        Cotizacion::getFecha,
                        cotizacion -> cotizacion
                ));

        Map<Long, UUID> cotizacionMapping = new HashMap<>();
        for (CotizacionDto commonCotizacion : commonCotizaciones) {
            if (commonCotizacion.getFecha() != null) {
                Cotizacion matchingCotizacion = cotizacionesMap.get(commonCotizacion.getFecha());
                if (matchingCotizacion != null && matchingCotizacion.getCotizacionId() != null
                        && commonCotizacion.getCotizacionId() != null) {
                    cotizacionMapping.put(matchingCotizacion.getCotizacionId(), commonCotizacion.getCotizacionId());
                }
            }
        }


        // Procesar proveedores en lotes para mejor rendimiento
        List<Proveedor> proveedores = proveedorService.findAll();
        log.debug("Found {} proveedores to migrate", proveedores.size());

        proveedores.parallelStream()
                .map(proveedor -> {
                    log.debug("Migrating proveedor");
                    logProveedor(proveedor);
                    return proveedorConvertToDto(proveedor);
                })
                .forEach(proveedorDto -> {
                    ProveedorDto updatedDto = proveedorClient.addOrUpdate(proveedorDto);
                    logProveedorDto(updatedDto);
                });
        var commonProveedores = proveedorClient.findAll();

        Map<Long, Proveedor> proveedoresMap = proveedores.stream()
                .filter(p -> p.getProveedorId() != null)
                .collect(Collectors.toMap(
                        Proveedor::getProveedorId,
                        proveedor -> proveedor
                ));

        Map<Long, UUID> proveedorMapping = new HashMap<>();
        for (ProveedorDto commonProveedor : commonProveedores) {
            if (commonProveedor.getProveedorIdOld() != null) {
                Proveedor matchingProveedor = proveedoresMap.get(commonProveedor.getProveedorIdOld());
                if (matchingProveedor != null && matchingProveedor.getProveedorId() != null
                        && commonProveedor.getProveedorId() != null) {
                    proveedorMapping.put(matchingProveedor.getProveedorId(), commonProveedor.getProveedorId());
                }
            }
        }

        // Procesar articulos en lotes para mejor rendimiento
        List<Articulo> articulos = articuloService.findAll();
        log.debug("Found {} articulos to migrate", articulos.size());

        articulos.parallelStream()
                .map(articulo -> {
                    log.debug("Migrating articulo");
                    logArticulo(articulo);
                    return articuloConvertToDto(articulo, cotizacionMapping.get(articulo.getCotizacionId()), proveedorMapping.get(articulo.getProveedorId()));
                })
                .forEach(articuloDto -> {
                    ArticuloDto updatedDto = articuloClient.addOrUpdate(articuloDto);
                    logArticuloDto(updatedDto);
                });

        // Procesar articuloAlias en lotes para mejor rendimiento
        List<ArticuloAlias> articuloAliases = articuloAliasService.findAll();
        log.debug("Found {} articuloAliases to migrate", articuloAliases.size());

        articuloAliases.parallelStream()
                .map(articuloAlias -> {
                    try {
                        log.debug("Migrating articuloAlias");
                        logArticuloAlias(articuloAlias);
                        var articuloCommon = articuloClient.findByCodigoArticulo(articuloAlias.getArticuloId());
                        return articuloAliasConvertToDto(articuloAlias, articuloCommon.getArticuloId(), proveedorMapping.get(articuloAlias.getProveedorId()));
                    } catch (Exception e) {
                        log.error("Error processing articuloAlias: {} - Error: {}", articuloAlias.getAlias(), e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .forEach(articuloAliasDto -> {
                    ArticuloAliasDto updatedDto = articuloAliasClient.addOrUpdate(articuloAliasDto);
                    logArticuloAliasDto(updatedDto);
                });
    }

    public void migrateOne(String alias) {
        log.debug("Processing migrateOne -> {}", alias);
        var articuloAlias = articuloAliasService.findByAlias(alias);
        logArticuloAlias(articuloAlias);
        var articuloCommon = articuloClient.findByCodigoArticulo(articuloAlias.getArticuloId());
        logArticuloDto(articuloCommon);
        var proveedorOne = proveedorService.findByProveedorId(articuloAlias.getProveedorId());
        logProveedor(proveedorOne);
        var proveedorDto = proveedorClient.findByProveedorIdOld(proveedorOne.getProveedorId());
        log.debug("Proveedor directo");
        logProveedorDto(proveedorDto);

        List<Proveedor> proveedores = proveedorService.findAll();
        var commonProveedores = proveedorClient.findAll();
        Map<Long, Proveedor> proveedoresMap = proveedores.stream()
                .filter(p -> p.getProveedorId() != null)
                .collect(Collectors.toMap(
                        Proveedor::getProveedorId,
                        proveedor -> proveedor
                ));

        Map<Long, UUID> proveedorMapping = new HashMap<>();
        for (ProveedorDto commonProveedor : commonProveedores) {
            if (commonProveedor.getProveedorIdOld() != null) {
                Proveedor matchingProveedor = proveedoresMap.get(commonProveedor.getProveedorIdOld());
                if (matchingProveedor != null && matchingProveedor.getProveedorId() != null
                        && commonProveedor.getProveedorId() != null) {
                    proveedorMapping.put(matchingProveedor.getProveedorId(), commonProveedor.getProveedorId());
                }
            }
        }

        proveedorDto = proveedorClient.findByProveedorId(proveedorMapping.get(articuloAlias.getProveedorId()));
        log.debug("Proveedor cruzado");
        logProveedorDto(proveedorDto);

        var articuloAliasDto = articuloAliasConvertToDto(articuloAlias, articuloCommon.getArticuloId(), proveedorMapping.get(articuloAlias.getProveedorId()));
        log.debug("ArticuloAliasDto before");
        logArticuloAliasDto(articuloAliasDto);
        articuloAliasDto = articuloAliasClient.addOrUpdate(articuloAliasDto);
        log.debug("ArticuloAliasDto after");
        logArticuloAliasDto(articuloAliasDto);
    }

    private void logCotizacion(Cotizacion cotizacion) {
        try {
            log.debug("Cotizacion -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(cotizacion));
        } catch (JsonProcessingException e) {
            log.error("Cotizacion jsonify error -> {}", e.getMessage());
        }
    }

    private void logCotizacionDto(CotizacionDto cotizacionDto) {
        try {
            log.debug("CotizacionDto -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(cotizacionDto));
        } catch (JsonProcessingException e) {
            log.error("CotizacionDto jsonify error -> {}", e.getMessage());
        }
    }

    private void logProveedor(Proveedor proveedor) {
        try {
            log.debug("Proveedor -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(proveedor));
        } catch (JsonProcessingException e) {
            log.error("Proveedor jsonify error -> {}", e.getMessage());
        }
    }

    private void logProveedorDto(ProveedorDto proveedorDto) {
        try {
            log.debug("ProveedorDto -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(proveedorDto));
        } catch (JsonProcessingException e) {
            log.error("ProveedorDto jsonify error -> {}", e.getMessage());
        }
    }

    private void logArticulo(Articulo articulo) {
        try {
            log.debug("Articulo -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articulo));
        } catch (JsonProcessingException e) {
            log.error("Articulo jsonify error -> {}", e.getMessage());
        }
    }

    private void logArticuloDto(ArticuloDto articuloDto) {
        try {
            log.debug("ArticuloDto -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articuloDto));
        } catch (JsonProcessingException e) {
            log.error("ArticuloDto jsonify error -> {}", e.getMessage());
        }
    }

    private void logArticuloAlias(ArticuloAlias articuloAlias) {
        try {
            log.debug("ArticuloAlias -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articuloAlias));
        } catch (JsonProcessingException e) {
            log.error("ArticuloAlias jsonify error -> {}", e.getMessage());
        }
    }

    private void logArticuloAliasDto(ArticuloAliasDto articuloAliasDto) {
        try {
            log.debug("ArticuloAliasDto -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articuloAliasDto));
        } catch (JsonProcessingException e) {
            log.error("ArticuloAliasDto jsonify error -> {}", e.getMessage());
        }
    }

    private CotizacionDto cotizacionConvertToDto(Cotizacion cotizacion) {
        return new CotizacionDto.Builder()
                .cotizacionId(null)
                .fecha(cotizacion.getFecha())
                .usdCompra(cotizacion.getUsdCompra())
                .usdVenta(cotizacion.getUsdVenta())
                .build();
    }

    private ProveedorDto proveedorConvertToDto(Proveedor proveedor) {
        return new ProveedorDto.Builder()
                .proveedorId(null)
                .proveedorIdOld(proveedor.getProveedorId())
                .razonSocial(proveedor.getRazonSocial())
                .nombreFantasia(proveedor.getNombreFantasia())
                .cuit(proveedor.getCuit())
                .domicilio(proveedor.getDomicilio())
                .localidad(proveedor.getLocalidad())
                .provincia(proveedor.getProvincia())
                .telefono(proveedor.getTelefono())
                .fax(proveedor.getFax())
                .email(proveedor.getEmail())
                .posicionIva(proveedor.getPosicionIva())
                .celular(proveedor.getCelular())
                .ingresosBrutos(proveedor.getIngresosBrutos())
                .contacto(proveedor.getContacto())
                .observaciones(proveedor.getObservaciones())
                .build();
    }

    private ArticuloDto articuloConvertToDto(Articulo articulo, UUID cotizacionId, UUID proveedorId) {
        return new ArticuloDto.Builder()
                .articuloId(null) // articuloId será asignado por el otro sistema
                .codigoArticulo(Objects.requireNonNull(articulo.getArticuloId()))
                .descripcion(articulo.getDescripcion() != null ? articulo.getDescripcion() : "")
                .precioVentaConIva(articulo.getPrecioventaconiva())
                .precioVentaSinIva(articulo.getPrecioventasiniva())
                .precioListaConIva(articulo.getPreciolistaconiva())
                .precioListaSinIva(articulo.getPreciolistasiniva())
                .precioCompraSinIva(articulo.getPreciocomprasiniva())
                .precioCompraSinIvaAnterior(articulo.getPreciocomprasinivaanterior())
                .flagIva105(articulo.getIva105())
                .flagExento(articulo.getExento())
                .modeloCamion(articulo.getModelocamion() != null ? articulo.getModelocamion() : "")
                .fechaActualizacion(articulo.getFechaactualizacion() != null ?
                        OffsetDateTime.ofInstant(articulo.getFechaactualizacion().toInstant(), ZoneOffset.UTC) : null)
                .origen(articulo.getOrigen() != null ? articulo.getOrigen() : "")
                .descuento(articulo.getDescuento() != null ? articulo.getDescuento() : "")
                .proveedorId(proveedorId)
                .ultimaCompra(articulo.getUltimacompra() != null ?
                        OffsetDateTime.ofInstant(articulo.getUltimacompra().toInstant(), ZoneOffset.UTC) : null)
                .marca(articulo.getMarca() != null ? articulo.getMarca() : "")
                .catalogo(articulo.getCatalogo() != null ? articulo.getCatalogo() : "")
                .precioListaSinIvaUsd(articulo.getPreciolistasinivausd())
                .cotizacionId(cotizacionId)
                .build();
    }

    private ArticuloAliasDto articuloAliasConvertToDto(ArticuloAlias articuloAlias, UUID articuloId, UUID proveedorId) {
        return new ArticuloAliasDto.Builder()
                .articuloAliasId(null)
                .articuloId(articuloId)
                .alias(Objects.requireNonNull(articuloAlias.getAlias()))
                .proveedorId(proveedorId)
                .precioCompra(articuloAlias.getPrecioCompra())
                .build();
    }

}
