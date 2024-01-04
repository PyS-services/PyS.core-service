package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.ClienteMovimiento
import java.util.Optional

@Repository
interface IClienteMovimientoRepository : JpaRepository<ClienteMovimiento, Long> {

    fun findAllByClienteIdAndComprobanteIdInOrderByClientemovimientoIdDesc(
        clienteId: Long,
        comprobanteIds: List<Int>
    ): List<ClienteMovimiento?>?

    fun findByClientemovimientoId(clientemovimientoId: Long): Optional<ClienteMovimiento?>?

}