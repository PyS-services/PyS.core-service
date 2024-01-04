package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.exception.ClienteNotFoundException;
import pys.api.rest.kotlin.model.Cliente;
import pys.api.rest.kotlin.repository.IClienteRepository;

@Service
public class ClienteService {

    private final IClienteRepository repository;

    @Autowired
    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente findByClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId).orElseThrow(() -> new ClienteNotFoundException(clienteId));
    }

}
