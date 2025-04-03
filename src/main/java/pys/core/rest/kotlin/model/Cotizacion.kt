package pys.core.rest.kotlin.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
data class Cotizacion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var cotizacionId: Long? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fecha: OffsetDateTime? = null,

    var usdCompra: BigDecimal = BigDecimal.ZERO,
    var usdVenta: BigDecimal = BigDecimal.ZERO

)
