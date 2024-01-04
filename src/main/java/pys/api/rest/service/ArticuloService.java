package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.exception.ArticuloNotFoundException;
import pys.api.rest.kotlin.model.Articulo;
import pys.api.rest.kotlin.repository.IArticuloRepository;

@Service
public class ArticuloService {

    private final IArticuloRepository repository;

    @Autowired
    public ArticuloService(IArticuloRepository repository) {
        this.repository = repository;
    }

    public Articulo findByArticuloId(String articuloId) {
        return repository.findByArticuloId(articuloId).orElseThrow(() -> new ArticuloNotFoundException(articuloId));
    }

}
