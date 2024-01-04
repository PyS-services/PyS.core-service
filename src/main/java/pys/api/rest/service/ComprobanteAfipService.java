package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.exception.ComprobanteAfipNotFoundException;
import pys.api.rest.kotlin.model.ComprobanteAfip;
import pys.api.rest.kotlin.repository.IComprobanteAfipRepository;

@Service
public class ComprobanteAfipService {

    private final IComprobanteAfipRepository repository;

    @Autowired
    public ComprobanteAfipService(IComprobanteAfipRepository repository) {
        this.repository = repository;
    }

    public ComprobanteAfip findByComprobanteafipId(Integer comprobanteafipId) {
        return repository.findByComprobanteafipId(comprobanteafipId)
                .orElseThrow(() -> new ComprobanteAfipNotFoundException(comprobanteafipId));
    }

}
