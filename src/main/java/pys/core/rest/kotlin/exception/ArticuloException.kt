package pys.core.rest.kotlin.exception

class ArticuloException(articuloId: String) : RuntimeException("Cannot find Articulo $articuloId")