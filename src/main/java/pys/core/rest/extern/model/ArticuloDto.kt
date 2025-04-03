package pys.core.rest.extern.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

data class ArticuloDto(

    var articuloId: UUID? = null,

    var codigoArticulo: String = "",
    var descripcion: String = "",
    var precioVentaConIva: BigDecimal = BigDecimal("0.00"),
    var precioVentaSinIva: BigDecimal = BigDecimal("0.00"),
    var precioListaConIva: BigDecimal = BigDecimal("0.00"),
    var precioListaSinIva: BigDecimal = BigDecimal("0.00"),
    var precioCompraSinIva: BigDecimal = BigDecimal("0.00"),
    var precioCompraSinIvaAnterior: BigDecimal = BigDecimal("0.00"),
    var flagIva105: Byte = 0,
    var flagExento: Byte = 0,
    var modeloCamion: String = "",

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fechaActualizacion: OffsetDateTime? = null,
    var origen: String = "",
    var descuento: String = "",
    var proveedorId: UUID? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var ultimaCompra: OffsetDateTime? = null,
    var marca: String = "",
    var catalogo: String = "",
    var precioListaSinIvaUsd: BigDecimal = BigDecimal("0.00"),
    var cotizacionId: UUID? = null,
    var proveedor: ProveedorDto? = null,
    var cotizacion: CotizacionDto? = null,

) {
    companion object {
        fun builder() = Builder()
    }

    class Builder {
        private var articuloId: UUID? = null
        private var codigoArticulo: String = ""
        private var descripcion: String = ""
        private var precioVentaConIva: BigDecimal = BigDecimal("0.00")
        private var precioVentaSinIva: BigDecimal = BigDecimal("0.00")
        private var precioListaConIva: BigDecimal = BigDecimal("0.00")
        private var precioListaSinIva: BigDecimal = BigDecimal("0.00")
        private var precioCompraSinIva: BigDecimal = BigDecimal("0.00")
        private var precioCompraSinIvaAnterior: BigDecimal = BigDecimal("0.00")
        private var flagIva105: Byte = 0
        private var flagExento: Byte = 0
        private var modeloCamion: String = ""
        private var fechaActualizacion: OffsetDateTime? = null
        private var origen: String = ""
        private var descuento: String = ""
        private var proveedorId: UUID? = null
        private var ultimaCompra: OffsetDateTime? = null
        private var marca: String = ""
        private var catalogo: String = ""
        private var precioListaSinIvaUsd: BigDecimal = BigDecimal("0.00")
        private var cotizacionId: UUID? = null
        private var proveedor: ProveedorDto? = null
        private var cotizacion: CotizacionDto? = null

        fun articuloId(articuloId: UUID?) = apply { this.articuloId = articuloId }
        fun codigoArticulo(codigoArticulo: String) = apply { this.codigoArticulo = codigoArticulo }
        fun descripcion(descripcion: String) = apply { this.descripcion = descripcion }
        fun precioVentaConIva(precioVentaConIva: BigDecimal) = apply { this.precioVentaConIva = precioVentaConIva }
        fun precioVentaSinIva(precioVentaSinIva: BigDecimal) = apply { this.precioVentaSinIva = precioVentaSinIva }
        fun precioListaConIva(precioListaConIva: BigDecimal) = apply { this.precioListaConIva = precioListaConIva }
        fun precioListaSinIva(precioListaSinIva: BigDecimal) = apply { this.precioListaSinIva = precioListaSinIva }
        fun precioCompraSinIva(precioCompraSinIva: BigDecimal) = apply { this.precioCompraSinIva = precioCompraSinIva }
        fun precioCompraSinIvaAnterior(precioCompraSinIvaAnterior: BigDecimal) = apply { this.precioCompraSinIvaAnterior = precioCompraSinIvaAnterior }
        fun flagIva105(flagIva105: Byte) = apply { this.flagIva105 = flagIva105 }
        fun flagExento(flagExento: Byte) = apply { this.flagExento = flagExento }
        fun modeloCamion(modeloCamion: String) = apply { this.modeloCamion = modeloCamion }
        fun fechaActualizacion(fechaActualizacion: OffsetDateTime?) = apply { this.fechaActualizacion = fechaActualizacion }
        fun origen(origen: String) = apply { this.origen = origen }
        fun descuento(descuento: String) = apply { this.descuento = descuento }
        fun proveedorId(proveedorId: UUID?) = apply { this.proveedorId = proveedorId }
        fun ultimaCompra(ultimaCompra: OffsetDateTime?) = apply { this.ultimaCompra = ultimaCompra }
        fun marca(marca: String) = apply { this.marca = marca }
        fun catalogo(catalogo: String) = apply { this.catalogo = catalogo }
        fun precioListaSinIvaUsd(precioListaSinIvaUsd: BigDecimal) = apply { this.precioListaSinIvaUsd = precioListaSinIvaUsd }
        fun cotizacionId(cotizacionId: UUID?) = apply { this.cotizacionId = cotizacionId }
        fun proveedor(proveedor: ProveedorDto?) = apply { this.proveedor = proveedor }
        fun cotizacion(cotizacion: CotizacionDto?) = apply { this.cotizacion = cotizacion }

        fun build() = ArticuloDto(
            articuloId,
            codigoArticulo,
            descripcion,
            precioVentaConIva,
            precioVentaSinIva,
            precioListaConIva,
            precioListaSinIva,
            precioCompraSinIva,
            precioCompraSinIvaAnterior,
            flagIva105,
            flagExento,
            modeloCamion,
            fechaActualizacion,
            origen,
            descuento,
            proveedorId,
            ultimaCompra,
            marca,
            catalogo,
            precioListaSinIvaUsd,
            cotizacionId,
            proveedor,
            cotizacion
        )
    }
}
