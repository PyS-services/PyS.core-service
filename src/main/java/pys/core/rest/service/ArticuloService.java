package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ArticuloNotFoundException;
import pys.core.rest.kotlin.model.Articulo;
import pys.core.rest.kotlin.repository.IArticuloRepository;

@Service
public class ArticuloService {

    private final IArticuloRepository repository;

    public ArticuloService(IArticuloRepository repository) {
        this.repository = repository;
    }

    public Articulo findByArticuloId(String articuloId) {
        return repository.findByArticuloId(articuloId).orElseThrow(() -> new ArticuloNotFoundException(articuloId));
    }

}
