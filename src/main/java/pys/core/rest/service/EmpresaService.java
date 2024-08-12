package pys.core.rest.service;

import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.exception.EmpresaNotFoundException;
import pys.core.rest.kotlin.model.Empresa;
import pys.core.rest.kotlin.repository.IEmpresaRepository;

@Service
public class EmpresaService {

    private final IEmpresaRepository repository;

    public EmpresaService(IEmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa findTop() {
        return repository.findTopByOrderByEmpresaIdDesc().orElseThrow(EmpresaNotFoundException::new);
    }

}
