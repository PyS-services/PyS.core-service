package pys.core.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ClienteMovimientoNotFoundException;
import pys.core.rest.kotlin.model.ClienteMovimiento;
import pys.core.rest.kotlin.model.Comprobante;
import pys.core.rest.kotlin.repository.IClienteMovimientoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteMovimientoService {

    private final IClienteMovimientoRepository repository;
    private final ComprobanteService comprobanteService;

    @Autowired
    public ClienteMovimientoService(IClienteMovimientoRepository repository, ComprobanteService comprobanteService) {
        this.repository = repository;
        this.comprobanteService = comprobanteService;
    }

    public List<ClienteMovimiento> findAllAsociables(Long clienteId) {
        List<Integer> comprobanteIds = comprobanteService.findAllAsociables().stream()
                .map(Comprobante::getComprobanteId).collect(Collectors.toList());
        return repository.findAllByClienteIdAndComprobanteIdInOrderByClientemovimientoIdDesc(clienteId, comprobanteIds);
    }

    public ClienteMovimiento findByClientemovimientoId(Long clientemovimientoId) {
        return repository.findByClientemovimientoId(clientemovimientoId)
                .orElseThrow(() -> new ClienteMovimientoNotFoundException(clientemovimientoId));
    }

}