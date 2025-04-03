package pys.core.rest.extern.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

data class CotizacionDto(

    var cotizacionId: UUID? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fecha: OffsetDateTime? = null,
    var usdCompra: BigDecimal = BigDecimal("0.00"),
    var usdVenta: BigDecimal = BigDecimal("0.00")

) {
    class Builder {
        private var cotizacionId: UUID? = null
        private var fecha: OffsetDateTime? = null
        private var usdCompra: BigDecimal = BigDecimal("0.00")
        private var usdVenta: BigDecimal = BigDecimal("0.00")

        fun cotizacionId(cotizacionId: UUID?) = apply { this.cotizacionId = cotizacionId }
        fun fecha(fecha: OffsetDateTime?) = apply { this.fecha = fecha }
        fun usdCompra(usdCompra: BigDecimal) = apply { this.usdCompra = usdCompra }
        fun usdVenta(usdVenta: BigDecimal) = apply { this.usdVenta = usdVenta }

        fun build() = CotizacionDto(
            cotizacionId = cotizacionId,
            fecha = fecha,
            usdCompra = usdCompra,
            usdVenta = usdVenta
        )
    }

    companion object {
        fun builder() = Builder()
    }
}
