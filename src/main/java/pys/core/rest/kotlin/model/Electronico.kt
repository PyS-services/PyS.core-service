package pys.core.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.math.BigDecimal

@Entity
@Table(
    name = "registrocae",
    uniqueConstraints = [UniqueConstraint(columnNames = ["rec_tco_id", "rec_prefijo", "rec_nrocomprob"])]
)
data class Electronico(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id")
    var electronicoId: Long? = null,

    @Column(name = "rec_tco_id")
    var comprobanteId: Int? = null,

    @Column(name = "rec_prefijo")
    var puntoventa: Int = 0,

    @Column(name = "rec_nrocomprob")
    var numerocomprobante: Long = 0L,

    @Column(name = "rec_cli_id")
    var clienteId: Long? = null,

    @Column(name = "rec_total")
    var total: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_exento")
    var exento: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_neto")
    var neto21: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_neto105")
    var neto105: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_iva")
    var iva21: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_iva105")
    var iva105: BigDecimal = BigDecimal.ZERO,

    @Column(name = "rec_cae")
    var cae: String = "",

    @Column(name = "rec_fecha")
    var fecha: String? = null,

    @Column(name = "rec_caevenc")
    var caevencimiento: String? = null,

    @Column(name = "rec_barras")
    var codigobarras: String = "",

    @Column(name = "tipo_documento")
    var tipodocumento: Int? = null,

    @Column(name = "numero_documento")
    var numerodocumento: BigDecimal? = null,

    @Column(name = "cliente_movimiento_id_asociado")
    var clientemovimientoIdasociado: Long? = null

)
