package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.Comprobante
import java.util.Optional

@Repository
interface IComprobanteRepository : JpaRepository<Comprobante, Long> {

    fun findAllByElectronicoAndAsociado(electronico: Byte, asociado: Byte): List<Comprobante?>?

    fun findByComprobanteId(comprobanteId: Int): Optional<Comprobante?>?

}