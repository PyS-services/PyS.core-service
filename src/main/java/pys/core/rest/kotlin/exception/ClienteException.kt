package pys.core.rest.kotlin.exception

class ClienteException(clienteId: Long) : RuntimeException("Cannot find Cliente $clienteId")