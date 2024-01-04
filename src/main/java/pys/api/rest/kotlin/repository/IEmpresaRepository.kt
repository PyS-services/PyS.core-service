package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.Empresa
import java.util.Optional

@Repository
interface IEmpresaRepository : JpaRepository<Empresa, Int> {

    fun findTopByOrderByEmpresaIdDesc(): Optional<Empresa?>?

}