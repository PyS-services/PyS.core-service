package pys.api.rest.kotlin.exception

class ElectronicoNotFoundException(comprobanteId: Int, puntoVenta: Int, numeroComprobante: Long) : RuntimeException(
    "Cannot find Electronico $comprobanteId/$puntoVenta/$numeroComprobante"
)