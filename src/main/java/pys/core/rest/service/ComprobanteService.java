package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ComprobanteException;
import pys.core.rest.kotlin.model.Comprobante;
import pys.core.rest.kotlin.repository.ComprobanteRepository;

import java.util.List;

@Service
public class ComprobanteService {

    private final ComprobanteRepository repository;

    public ComprobanteService(ComprobanteRepository repository) {
        this.repository = repository;
    }

    public List<Comprobante> findAllAsociables() {
        return repository.findAllByElectronicoAndAsociado((byte) 1, (byte) 0);
    }

    public Comprobante findByComprobanteId(Integer comprobanteId) {
        return repository.findByComprobanteId(comprobanteId)
                .orElseThrow(() -> new ComprobanteException(comprobanteId));
    }

}
