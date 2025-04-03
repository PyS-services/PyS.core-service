package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.model.Cotizacion;
import pys.core.rest.kotlin.repository.CotizacionRepository;

import java.util.List;

@Service
public class CotizacionService {

    private final CotizacionRepository repository;

    public CotizacionService(CotizacionRepository repository) {
        this.repository = repository;
    }

    public List<Cotizacion> findAll() {
        return repository.findAll();
    }

}
