package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ClienteMovimientoException;
import pys.core.rest.kotlin.model.ClienteMovimiento;
import pys.core.rest.kotlin.model.Comprobante;
import pys.core.rest.kotlin.repository.ClienteMovimientoRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClienteMovimientoService {

    private final ClienteMovimientoRepository repository;
    private final ComprobanteService comprobanteService;

    public ClienteMovimientoService(ClienteMovimientoRepository repository, ComprobanteService comprobanteService) {
        this.repository = repository;
        this.comprobanteService = comprobanteService;
    }

    public List<ClienteMovimiento> findAllAsociables(Long clienteId) {
        List<Integer> comprobanteIds = comprobanteService.findAllAsociables().stream()
                .map(Comprobante::getComprobanteId).collect(Collectors.toList());
        return repository.findAllByClienteIdAndComprobanteIdInOrderByClienteMovimientoIdDesc(clienteId, comprobanteIds);
    }

    public ClienteMovimiento findByClienteMovimientoId(Long clienteMovimientoId) {
        return Objects.requireNonNull(repository.findByClienteMovimientoId(clienteMovimientoId))
                .orElseThrow(() -> new ClienteMovimientoException(clienteMovimientoId));
    }

}