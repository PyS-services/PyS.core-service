package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.Cotizacion

@Repository
interface CotizacionRepository : JpaRepository<Cotizacion, Long> {

}