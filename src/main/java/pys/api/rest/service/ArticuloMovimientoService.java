package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.model.ArticuloMovimiento;
import pys.api.rest.kotlin.repository.IArticuloMovimientoRepository;

import java.util.List;

@Service
public class ArticuloMovimientoService {

    private final IArticuloMovimientoRepository repository;

    @Autowired
    public ArticuloMovimientoService(IArticuloMovimientoRepository repository) {
        this.repository = repository;
    }

    public List<ArticuloMovimiento> findAllByClientemovimientoId(Long clientemovimientoId) {
        return repository.findAllByClientemovimientoId(clientemovimientoId);
    }

}
