package pys.core.rest.kotlin.exception

class ComprobanteException(comprobanteId: Int) : RuntimeException("Cannot find Comprobante $comprobanteId")