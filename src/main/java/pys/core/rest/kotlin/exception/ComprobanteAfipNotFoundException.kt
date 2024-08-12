package pys.core.rest.kotlin.exception

class ComprobanteAfipNotFoundException(comprobanteafipId: Int) :
    RuntimeException("Cannot find ComprobanteAfip $comprobanteafipId")