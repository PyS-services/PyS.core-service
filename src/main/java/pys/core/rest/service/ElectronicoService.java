package pys.core.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ElectronicoException;
import pys.core.rest.kotlin.model.Electronico;
import pys.core.rest.kotlin.repository.ElectronicoRepository;

@Service
public class ElectronicoService {

    private final ElectronicoRepository repository;

    @Autowired
    public ElectronicoService(ElectronicoRepository repository) {
        this.repository = repository;
    }

    public Electronico findByUnique(Integer comprobanteId, Integer puntoventa, Long numerocomprobante) {
        return repository
                .findByComprobanteIdAndPuntoventaAndNumerocomprobante(comprobanteId, puntoventa, numerocomprobante)
                .orElseThrow(() -> new ElectronicoException(comprobanteId, puntoventa, numerocomprobante));
    }

}
