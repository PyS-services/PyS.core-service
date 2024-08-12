package pys.core.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ComprobanteNotFoundException;
import pys.core.rest.kotlin.model.Comprobante;
import pys.core.rest.kotlin.repository.IComprobanteRepository;

import java.util.List;

@Service
public class ComprobanteService {

    private final IComprobanteRepository repository;

    public ComprobanteService(IComprobanteRepository repository) {
        this.repository = repository;
    }

    public List<Comprobante> findAllAsociables() {
        return repository.findAllByElectronicoAndAsociado((byte) 1, (byte) 0);
    }

    public Comprobante findByComprobanteId(Integer comprobanteId) {
        return repository.findByComprobanteId(comprobanteId)
                .orElseThrow(() -> new ComprobanteNotFoundException(comprobanteId));
    }

}
