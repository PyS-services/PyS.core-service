package pys.core.rest.kotlin.exception

class ProveedorException : RuntimeException {
    constructor(proveedorId: Long) : super("Proveedor no encontrado con proveedorId $proveedorId")
}