package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.Cliente
import java.util.Optional

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {

    fun findByClienteId(clienteId: Long): Optional<Cliente?>?

}