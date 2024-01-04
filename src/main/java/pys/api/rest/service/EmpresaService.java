package pys.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pys.api.rest.kotlin.exception.EmpresaNotFoundException;
import pys.api.rest.kotlin.model.Empresa;
import pys.api.rest.kotlin.repository.IEmpresaRepository;

@Service
public class EmpresaService {

    private final IEmpresaRepository repository;

    @Autowired
    public EmpresaService(IEmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa findTop() {
        return repository.findTopByOrderByEmpresaIdDesc().orElseThrow(EmpresaNotFoundException::new);
    }

}
