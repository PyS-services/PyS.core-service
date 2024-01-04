package pys.api.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.Date

@Entity
@Table(name = "articulos")
data class Articulo(

    @Id
    @Column(name = "codigo")
    var articuloId: String? = null,

    @Column(name = "descripcion")
    var descripcion: String? = null,

    @Column(name = "art_precioventaconiva")
    var precioventaconiva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "art_precioventasiniva")
    var precioventasiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "art_preciolistaconiva")
    var preciolistaconiva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "art_preciolistasiniva")
    var preciolistasiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "art_preciocomprasiniva")
    var preciocomprasiniva: BigDecimal = BigDecimal.ZERO,

    @Column(name = "art_preciocomprasinivaanterior")
    var preciocomprasinivaanterior: BigDecimal = BigDecimal.ZERO,

    @Column(name = "iva105")
    var iva105: Byte = 0,

    @Column(name = "exento")
    var exento: Byte = 0,

    @Column(name = "art_modelocamion")
    var modelocamion: String? = null,

    @Column(name = "art_fechaactualizacion")
    var fechaactualizacion: Date? = null,

    @Column(name = "art_origen")
    var origen: String? = null,

    @Column(name = "art_descuento")
    var descuento: String? = null,

    @Column(name = "art_prv_id")
    var proveedorId: Long? = null,

    @Column(name = "art_ultimacompra")
    var ultimacompra: Date? = null,

    @Column(name = "art_marca")
    var marca: String? = null,

    @Column(name = "art_catalogo")
    var catalogo: String? = null,

    @Column(name = "preciolistasinivausd")
    var preciolistasinivausd: BigDecimal = BigDecimal.ZERO,

    @Column(name = "cotizacionID")
    var cotizacionId: Long? = null,

    @Column(name = "clave")
    var autonumerico: Long? = null

)
