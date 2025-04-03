package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.Electronico
import java.util.Optional

@Repository
interface ElectronicoRepository : JpaRepository<Electronico, Long> {

    fun findByComprobanteIdAndPuntoventaAndNumerocomprobante(comprobanteId: Int, puntoventa: Int, numerocomprobante: Long): Optional<Electronico?>?

}