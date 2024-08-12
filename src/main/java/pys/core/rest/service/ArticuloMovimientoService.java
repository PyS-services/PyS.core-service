package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.model.ArticuloMovimiento;
import pys.core.rest.kotlin.repository.IArticuloMovimientoRepository;

import java.util.List;

@Service
public class ArticuloMovimientoService {

    private final IArticuloMovimientoRepository repository;

    public ArticuloMovimientoService(IArticuloMovimientoRepository repository) {
        this.repository = repository;
    }

    public List<ArticuloMovimiento> findAllByClientemovimientoId(Long clientemovimientoId) {
        return repository.findAllByClientemovimientoId(clientemovimientoId);
    }

}
