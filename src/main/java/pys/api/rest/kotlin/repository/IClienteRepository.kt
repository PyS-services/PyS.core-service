package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.Cliente
import java.util.Optional

@Repository
interface IClienteRepository : JpaRepository<Cliente, Long> {

    fun findByClienteId(clienteId: Long): Optional<Cliente?>?

}