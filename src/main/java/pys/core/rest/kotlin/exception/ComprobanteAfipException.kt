package pys.core.rest.kotlin.exception

class ComprobanteAfipException(comprobanteafipId: Int) :
    RuntimeException("Cannot find ComprobanteAfip $comprobanteafipId")