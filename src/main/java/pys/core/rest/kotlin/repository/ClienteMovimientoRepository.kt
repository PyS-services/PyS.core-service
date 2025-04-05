package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.ClienteMovimiento
import java.util.Optional

@Repository
interface ClienteMovimientoRepository : JpaRepository<ClienteMovimiento, Long> {

    fun findAllByClienteIdAndComprobanteIdInOrderByClientemovimientoIdDesc(
        clienteId: Long,
        comprobanteIds: List<Int>
    ): List<ClienteMovimiento?>?

    fun findByClientemovimientoId(clienteMovimientoId: Long): Optional<ClienteMovimiento?>?

}