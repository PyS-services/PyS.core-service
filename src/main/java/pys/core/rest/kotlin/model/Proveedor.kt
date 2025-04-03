package pys.core.rest.kotlin.model

import jakarta.persistence.*

@Entity
data class Proveedor(

    @Id
    val proveedorId: Long? = null,

    val razonSocial: String = "",
    val nombreFantasia: String = "",
    val cuit: String = "",
    val domicilio: String = "",
    val localidad: String = "",
    val provincia: String = "",
    val telefono: String = "",
    val fax: String = "",
    val email: String = "",
    val posicionIva: Int = 0,
    val celular: String = "",
    val ingresosBrutos: String = "",
    val contacto: String = "",
    val observaciones: String = "",
    val autoId: Long? = null

)
