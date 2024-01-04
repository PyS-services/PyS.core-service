package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.Electronico
import java.util.Optional

@Repository
interface IElectronicoRepository : JpaRepository<Electronico, Long> {

    fun findByComprobanteIdAndPuntoventaAndNumerocomprobante(comprobanteId: Int, puntoventa: Int, numerocomprobante: Long): Optional<Electronico?>?

}