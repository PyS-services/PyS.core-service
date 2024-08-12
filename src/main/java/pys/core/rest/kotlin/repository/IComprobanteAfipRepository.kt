package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.ComprobanteAfip
import java.util.Optional

@Repository
interface IComprobanteAfipRepository : JpaRepository<ComprobanteAfip, Int> {

    fun findByComprobanteafipId(comprobanteafipId: Int): Optional<ComprobanteAfip?>?

}