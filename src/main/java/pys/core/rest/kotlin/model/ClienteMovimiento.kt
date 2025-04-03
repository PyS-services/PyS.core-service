package pys.core.rest.kotlin.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
@Table(name = "movclie")
data class ClienteMovimiento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    var clienteMovimientoId: Long? = null,

    @Column(name = "mcl_neg_id")
    var negocioId: Int? = null,

    @Column(name = "mcl_emp_id")
    var empresaId: Int? = null,

    @Column(name = "cgoclie")
    var clienteId: Long? = null,

    @Column(name = "cgocomprob")
    var comprobanteId: Int? = null,

    @Column(name = "fechacomprob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fechaComprobante: OffsetDateTime? = null,

    @Column(name = "mcl_fechavenc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fechaVencimiento: OffsetDateTime? = null,

    @Column(name = "prefijo")
    var puntoVenta: Int = 0,

    @Column(name = "nrocomprob")
    var numeroComprobante: Long = 0L,

    @Column(name = "importe")
    var importe: BigDecimal = BigDecimal.ZERO,

    @Column(name = "cancelado")
    var cancelado: BigDecimal = BigDecimal.ZERO,

    @Column(name = "netosindescuento")
    var netoSinDescuento: BigDecimal = BigDecimal.ZERO,

    @Column(name = "neto")
    var neto: BigDecimal = BigDecimal.ZERO,

    @Column(name = "netocancelado")
    var netoCancelado: BigDecimal = BigDecimal.ZERO,

    @Column(name = "montoiva")
    var iva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "montoexento")
    var exento: BigDecimal = BigDecimal.ZERO,

    @Column(name = "recibo")
    var recibo: Byte = 0,

    @Column(name = "anulada")
    var anulada: Byte = 0,

    @Column(name = "tipocompro")
    var tipoComprobante: String = "",

    @Column(name = "mcl_letras")
    var letras: String = "",

    @Column(name = "mcl_iva")
    var alicuotaIva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "mcl_observaciones")
    var observaciones: String = "",

    @Column(name = "mcl_cae")
    var cae: String = "",

    @Column(name = "mcl_caevenc")
    var caeVencimiento: String = "",

    @Column(name = "mcl_barras")
    var barras: String = "",

    @OneToOne(optional = true)
    @JoinColumn(name = "cgoclie", insertable = false, updatable = false)
    var cliente: Cliente? = null,

)
