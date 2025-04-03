package pys.core.rest.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.ProveedorException;
import pys.core.rest.kotlin.model.Proveedor;
import pys.core.rest.kotlin.repository.ProveedorRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    public Proveedor findByProveedorId(Long proveedorId) {
        return Objects.requireNonNull(repository.findByProveedorId(proveedorId)).orElseThrow(() -> new ProveedorException(proveedorId));
    }

}
