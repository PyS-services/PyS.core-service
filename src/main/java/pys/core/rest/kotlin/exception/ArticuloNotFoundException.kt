package pys.core.rest.kotlin.exception

class ArticuloNotFoundException(articuloId: String) : RuntimeException("Cannot find Articulo $articuloId")