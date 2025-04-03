package pys.core.rest.kotlin.exception

class ClienteMovimientoException(clienteMovimientoId: Long) : RuntimeException("Cannot find ClienteMovimiento $clienteMovimientoId")