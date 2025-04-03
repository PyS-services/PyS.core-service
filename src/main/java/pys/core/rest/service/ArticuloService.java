package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ArticuloException;
import pys.core.rest.kotlin.model.Articulo;
import pys.core.rest.kotlin.repository.ArticuloRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ArticuloService {

    private final ArticuloRepository repository;

    public ArticuloService(ArticuloRepository repository) {
        this.repository = repository;
    }

    public List<Articulo> findAll() {
        return repository.findAll();
    }

    public Articulo findByArticuloId(String articuloId) {
        return Objects.requireNonNull(repository.findByArticuloId(articuloId)).orElseThrow(() -> new ArticuloException(articuloId));
    }

}
