package pys.api.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(name = "tiposcomprob", uniqueConstraints = [UniqueConstraint(columnNames = ["tco_neg_id", "codigo"])])
data class Comprobante(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    var uniqueId: Long? = null,

    @Column(name = "tco_neg_id")
    var negocioId: Int? = null,

    @Column(name = "codigo")
    var comprobanteId: Int? = null,

    @Column(name = "descripcion")
    var descripcion: String = "",

    @Column(name = "modulo")
    var modulo: Int = 0,

    @Column(name = "ctacte")
    var cuentacorriente: Byte = 0,

    @Column(name = "debita")
    var debita: Byte = 0,

    @Column(name = "iva")
    var iva: Byte = 0,

    @Column(name = "aplicapend")
    var aplicapendiente: Byte = 0,

    @Column(name = "aplicable")
    var aplicable: Byte = 0,

    @Column(name = "aplicacion")
    var aplicacion: Byte = 0,

    @Column(name = "libroiva")
    var libroiva: Byte = 0,

    @Column(name = "tipocomprob")
    var letracomprobante: String = "",

    @Column(name = "recibo")
    var recibo: Byte = 0,

    @Column(name = "contado")
    var contado: Byte = 0,

    @Column(name = "orden_pago")
    var ordenpago: Byte = 0,

    @Column(name = "tco_puntovta")
    var puntoventa: Int = 0,

    @Column(name = "tco_tipoafip")
    var comprobanteafipId: Int? = null,

    @Column(name = "tco_factelect")
    var electronico: Byte = 0,

    @Column(name = "asociado")
    var asociado: Byte = 0

)
