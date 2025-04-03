package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ComprobanteAfipException;
import pys.core.rest.kotlin.model.ComprobanteAfip;
import pys.core.rest.kotlin.repository.ComprobanteAfipRepository;

@Service
public class ComprobanteAfipService {

    private final ComprobanteAfipRepository repository;

    public ComprobanteAfipService(ComprobanteAfipRepository repository) {
        this.repository = repository;
    }

    public ComprobanteAfip findByComprobanteafipId(Integer comprobanteafipId) {
        return repository.findByComprobanteafipId(comprobanteafipId)
                .orElseThrow(() -> new ComprobanteAfipException(comprobanteafipId));
    }

}
