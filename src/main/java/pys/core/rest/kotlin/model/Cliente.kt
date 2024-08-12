package pys.core.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "clientes")
data class Cliente(

    @Id
    @Column(name = "codigo")
    var clienteId: Long? = null,

    @Column(name = "cli_neg_id")
    val negocioId: Int? = null,

    @Column(name = "cuit")
    val cuit: String = "",

    @Column(name = "razon")
    val razonsocial: String? = null,

    @Column(name = "domicilio")
    val domicilio: String = "",

    @Column(name = "cli_localidad")
    val localidad: String = "",

    @Column(name = "cli_provincia")
    val provincia: String = "",

    @Column(name = "tel")
    val telefono: String = "",

    @Column(name = "fax")
    val fax: String? = null,

    @Column(name = "email")
    val email: String = "",

    @Column(name = "celular")
    val numeromovil: String? = null,

    @Column(name = "posicion")
    val posicioniva: Int = 0,

    @Column(name = "tipodoc")
    val tipodocumento: String = "",

    @Column(name = "nrodoc")
    val numerodocumento: Long? = null,

    @Column(name = "limitecredito")
    val limitecredito: BigDecimal = BigDecimal.ZERO,

    @Column(name = "nacionalidad")
    val nacionalidad: String = "",

    @Column(name = "cli_descuento")
    val descuento: BigDecimal = BigDecimal.ZERO,

    @Column(name = "cli_facturable")
    val facturable: Byte = 0

)
