package pys.core.rest.extern.model

import java.util.UUID

data class ProveedorDto private constructor(
    val proveedorId: UUID?,
    val proveedorIdOld: Long?,
    val razonSocial: String,
    val nombreFantasia: String,
    val cuit: String,
    val domicilio: String,
    val localidad: String,
    val provincia: String,
    val telefono: String,
    val fax: String,
    val email: String,
    val posicionIva: Int,
    val celular: String,
    val ingresosBrutos: String,
    val contacto: String,
    val observaciones: String
) {
    class Builder {
        private var proveedorId: UUID? = null
        private var proveedorIdOld: Long? = null
        private var razonSocial: String = ""
        private var nombreFantasia: String = ""
        private var cuit: String = ""
        private var domicilio: String = ""
        private var localidad: String = ""
        private var provincia: String = ""
        private var telefono: String = ""
        private var fax: String = ""
        private var email: String = ""
        private var posicionIva: Int = 0
        private var celular: String = ""
        private var ingresosBrutos: String = ""
        private var contacto: String = ""
        private var observaciones: String = ""

        fun proveedorId(proveedorId: UUID?) = apply { this.proveedorId = proveedorId }
        fun proveedorIdOld(proveedorIdOld: Long?) = apply { this.proveedorIdOld = proveedorIdOld }
        fun razonSocial(razonSocial: String) = apply { this.razonSocial = razonSocial }
        fun nombreFantasia(nombreFantasia: String) = apply { this.nombreFantasia = nombreFantasia }
        fun cuit(cuit: String) = apply { this.cuit = cuit }
        fun domicilio(domicilio: String) = apply { this.domicilio = domicilio }
        fun localidad(localidad: String) = apply { this.localidad = localidad }
        fun provincia(provincia: String) = apply { this.provincia = provincia }
        fun telefono(telefono: String) = apply { this.telefono = telefono }
        fun fax(fax: String) = apply { this.fax = fax }
        fun email(email: String) = apply { this.email = email }
        fun posicionIva(posicionIva: Int) = apply { this.posicionIva = posicionIva }
        fun celular(celular: String) = apply { this.celular = celular }
        fun ingresosBrutos(ingresosBrutos: String) = apply { this.ingresosBrutos = ingresosBrutos }
        fun contacto(contacto: String) = apply { this.contacto = contacto }
        fun observaciones(observaciones: String) = apply { this.observaciones = observaciones }

        fun build() = ProveedorDto(
            proveedorId,
            proveedorIdOld,
            razonSocial,
            nombreFantasia,
            cuit,
            domicilio,
            localidad,
            provincia,
            telefono,
            fax,
            email,
            posicionIva,
            celular,
            ingresosBrutos,
            contacto,
            observaciones
        )
    }

    companion object {
        fun builder() = Builder()
    }
}
