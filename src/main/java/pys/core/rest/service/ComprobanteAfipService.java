package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ComprobanteAfipNotFoundException;
import pys.core.rest.kotlin.model.ComprobanteAfip;
import pys.core.rest.kotlin.repository.IComprobanteAfipRepository;

@Service
public class ComprobanteAfipService {

    private final IComprobanteAfipRepository repository;

    public ComprobanteAfipService(IComprobanteAfipRepository repository) {
        this.repository = repository;
    }

    public ComprobanteAfip findByComprobanteafipId(Integer comprobanteafipId) {
        return repository.findByComprobanteafipId(comprobanteafipId)
                .orElseThrow(() -> new ComprobanteAfipNotFoundException(comprobanteafipId));
    }

}
