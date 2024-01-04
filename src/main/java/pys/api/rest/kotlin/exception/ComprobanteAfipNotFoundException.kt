package pys.api.rest.kotlin.exception

class ComprobanteAfipNotFoundException(comprobanteafipId: Int) :
    RuntimeException("Cannot find ComprobanteAfip $comprobanteafipId")