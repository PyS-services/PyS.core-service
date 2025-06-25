package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.exception.PosicionIvaException;
import pys.core.rest.repository.PosicionIvaRepository;
import pys.core.rest.model.PosicionIva;

@Service
public class PosicionIvaService {

    private final PosicionIvaRepository repository;

    public PosicionIvaService(PosicionIvaRepository repository) {
        this.repository = repository;
    }

    public PosicionIva findByPosicionIvaId(Integer posicionIvaId) {
        return repository.findByPosicionIvaId(posicionIvaId).orElseThrow(() -> new PosicionIvaException(posicionIvaId));
    }

}
