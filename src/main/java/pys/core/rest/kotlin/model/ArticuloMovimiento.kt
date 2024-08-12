package pys.core.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.Date

@Entity
@Table(name = "detartic")
data class ArticuloMovimiento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    var articulomovimientoId: Long? = null,

    @Column(name = "clavemovclie")
    var clientemovimientoId: Long? = null,

    @Column(name = "cgocomprob")
    var comprobanteId: Int? = null,

    @Column(name = "item")
    var item: Int = 0,

    @Column(name = "dea_neg_id")
    var negocioId: Int? = null,

    @Column(name = "cgoartic")
    var articuloId: String? = null,

    @Column(name = "dea_descripcion")
    var descripcion: String? = null,

    @Column(name = "cantidad")
    var cantidad: BigDecimal = BigDecimal.ZERO,

    @Column(name = "precioventasiniva")
    var precioventasiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "precioventaconiva")
    var precioventaconiva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "preciodescuentosiniva")
    var preciodescuentosiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "preciodescuentoconiva")
    var preciodescuentoconiva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "iva105")
    var iva105: Byte = 0,

    @Column(name = "exento")
    var exento: Byte = 0,

    @Column(name = "fecha")
    var fecha: Date? = null,

    @Column(name = "fechafac")
    var fechafactura: Date? = null,

    @Column(name = "preciocomprasiniva")
    var preciocomprasiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "dea_descuento")
    var descuento: BigDecimal = BigDecimal.ZERO

)
