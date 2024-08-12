package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ClienteNotFoundException;
import pys.core.rest.kotlin.model.Cliente;
import pys.core.rest.kotlin.repository.IClienteRepository;

@Service
public class ClienteService {

    private final IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente findByClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId).orElseThrow(() -> new ClienteNotFoundException(clienteId));
    }

}
