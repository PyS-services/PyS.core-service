package pys.core.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "articulosalias")
data class ArticuloAlias(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    val articuloAliasId: Long? = null,

    @Column(name = "aal_art_id")
    val articuloId: String? = null,

    @Column(name = "aal_alias")
    val alias: String? = null,

    @Column(name = "aal_prv_id")
    val proveedorId: Long? = null,

    @Column(name = "aal_preciocompra")
    val precioCompra: BigDecimal = BigDecimal.ZERO,

) {
    companion object {
        class Builder {
            private var articuloAliasId: Long? = null
            private var articuloId: String? = null
            private var alias: String? = null
            private var proveedorId: Long? = null
            private var precioCompra: BigDecimal = BigDecimal.ZERO

            fun articuloAliasId(articuloAliasId: Long?) = apply { this.articuloAliasId = articuloAliasId }
            fun articuloId(articuloId: String?) = apply { this.articuloId = articuloId }
            fun alias(alias: String?) = apply { this.alias = alias }
            fun proveedorId(proveedorId: Long?) = apply { this.proveedorId = proveedorId }
            fun precioCompra(precioCompra: BigDecimal) = apply { this.precioCompra = precioCompra }

            fun build() = ArticuloAlias(
                articuloAliasId = articuloAliasId,
                articuloId = articuloId,
                alias = alias,
                proveedorId = proveedorId,
                precioCompra = precioCompra
            )
        }
    }
}
