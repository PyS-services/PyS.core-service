package pys.core.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "empresa")
data class Empresa(

    @Id
    @Column(name = "emp_id")
    var empresaId: Int? = null,

    @Column(name = "emp_neg_id")
    var negocioId: Int? = null,

    @Column(name = "nombre")
    var nombrefantasia: String? = null,

    @Column(name = "emp_rsocial")
    var razonsocial: String? = null,

    @Column(name = "domicilio")
    var domicilio: String? = null,

    @Column(name = "telf")
    var telefono: String? = null,

    @Column(name = "cuit")
    var cuit: String? = null,

    @Column(name = "puntovta")
    var puntoventa: Int? = null,

    @Column(name = "ingbrutos")
    var ingresosbrutos: String? = null,

    @Column(name = "nroestablecimiento")
    var numeroestablecimiento: String? = null,

    @Column(name = "sedetimbrado")
    var sedetimbrado: String? = null,

    @Column(name = "inicioactividades")
    var inicioactividades: String? = null,

    @Column(name = "condicioniva")
    var condicioniva: String? = null,

    @Column(name = "emp_ubicacion")
    var ubicacion: String? = null

)