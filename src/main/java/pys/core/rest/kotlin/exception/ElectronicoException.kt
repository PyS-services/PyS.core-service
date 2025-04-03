package pys.core.rest.kotlin.exception

class ElectronicoException(comprobanteId: Int, puntoVenta: Int, numeroComprobante: Long) : RuntimeException(
    "Cannot find Electronico $comprobanteId/$puntoVenta/$numeroComprobante"
)