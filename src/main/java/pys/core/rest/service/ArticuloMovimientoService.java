package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.model.ArticuloMovimiento;
import pys.core.rest.kotlin.repository.ArticuloMovimientoRepository;

import java.util.List;

@Service
public class ArticuloMovimientoService {

    private final ArticuloMovimientoRepository repository;

    public ArticuloMovimientoService(ArticuloMovimientoRepository repository) {
        this.repository = repository;
    }

    public List<ArticuloMovimiento> findAllByClientemovimientoId(Long clientemovimientoId) {
        return repository.findAllByClientemovimientoId(clientemovimientoId);
    }

}
