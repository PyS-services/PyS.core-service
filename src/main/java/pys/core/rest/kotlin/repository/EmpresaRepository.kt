package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.Empresa
import java.util.Optional

@Repository
interface EmpresaRepository : JpaRepository<Empresa, Int> {

    fun findTopByOrderByEmpresaIdDesc(): Optional<Empresa?>?

}