package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ClienteException;
import pys.core.rest.kotlin.model.Cliente;
import pys.core.rest.kotlin.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente findByClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId).orElseThrow(() -> new ClienteException(clienteId));
    }

}
