package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.EmpresaException;
import pys.core.rest.kotlin.model.Empresa;
import pys.core.rest.kotlin.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa findTop() {
        return repository.findTopByOrderByEmpresaIdDesc().orElseThrow(EmpresaException::new);
    }

}
