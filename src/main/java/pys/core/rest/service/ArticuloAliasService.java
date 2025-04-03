package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ArticuloAliasException;
import pys.core.rest.kotlin.model.ArticuloAlias;
import pys.core.rest.kotlin.repository.ArticuloAliasRepository;

import java.util.List;

@Service
public class ArticuloAliasService {

    private final ArticuloAliasRepository repository;

    public ArticuloAliasService(ArticuloAliasRepository repository) {
        this.repository = repository;
    }

    public List<ArticuloAlias> findAll() {
        return repository.findAll();
    }

    public ArticuloAlias findByAlias(String alias) {
        return repository.findByAlias(alias).orElseThrow(() -> new ArticuloAliasException(alias));
    }

}
