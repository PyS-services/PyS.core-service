package pys.core.rest.extern.model

import java.math.BigDecimal
import java.util.UUID

data class ArticuloAliasDto(

    val articuloAliasId: UUID? = null,
    val articuloId: UUID? = null,
    val alias: String = "",
    val proveedorId: UUID? = null,
    val precioCompra: BigDecimal = BigDecimal("0.00"),
    val articulo: ArticuloDto? = null,
    val proveedor: ProveedorDto? = null
) {
    companion object {
        fun builder() = Builder()
    }

    class Builder {
        private var articuloAliasId: UUID? = null
        private var articuloId: UUID? = null
        private var alias: String = ""
        private var proveedorId: UUID? = null
        private var precioCompra: BigDecimal = BigDecimal("0.00")
        private var articulo: ArticuloDto? = null
        private var proveedor: ProveedorDto? = null

        fun articuloAliasId(articuloAliasId: UUID?) = apply { this.articuloAliasId = articuloAliasId }
        fun articuloId(articuloId: UUID?) = apply { this.articuloId = articuloId }
        fun alias(alias: String) = apply { this.alias = alias }
        fun proveedorId(proveedorId: UUID?) = apply { this.proveedorId = proveedorId }
        fun precioCompra(precioCompra: BigDecimal) = apply { this.precioCompra = precioCompra }
        fun articulo(articulo: ArticuloDto?) = apply { this.articulo = articulo }
        fun proveedor(proveedor: ProveedorDto?) = apply { this.proveedor = proveedor }

        fun build() = ArticuloAliasDto(
            articuloAliasId,
            articuloId,
            alias,
            proveedorId,
            precioCompra,
            articulo,
            proveedor
        )
    }
}
