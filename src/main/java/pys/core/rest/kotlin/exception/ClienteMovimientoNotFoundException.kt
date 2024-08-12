package pys.core.rest.kotlin.exception

class ClienteMovimientoNotFoundException(clienteMovimientoId: Long) : RuntimeException("Cannot find ClienteMovimiento $clienteMovimientoId")