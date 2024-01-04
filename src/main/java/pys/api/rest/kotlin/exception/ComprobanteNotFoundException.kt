package pys.api.rest.kotlin.exception

import java.lang.RuntimeException

class ComprobanteNotFoundException(comprobanteId: Int) : RuntimeException("Cannot find Comprobante $comprobanteId")