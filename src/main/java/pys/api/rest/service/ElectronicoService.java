package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.exception.ElectronicoNotFoundException;
import pys.api.rest.kotlin.model.Electronico;
import pys.api.rest.kotlin.repository.IElectronicoRepository;

@Service
public class ElectronicoService {

    private final IElectronicoRepository repository;

    @Autowired
    public ElectronicoService(IElectronicoRepository repository) {
        this.repository = repository;
    }

    public Electronico findByUnique(Integer comprobanteId, Integer puntoventa, Long numerocomprobante) {
        return repository
                .findByComprobanteIdAndPuntoventaAndNumerocomprobante(comprobanteId, puntoventa, numerocomprobante)
                .orElseThrow(() -> new ElectronicoNotFoundException(comprobanteId, puntoventa, numerocomprobante));
    }

}
