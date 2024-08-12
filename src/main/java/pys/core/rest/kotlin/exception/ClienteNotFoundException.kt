package pys.core.rest.kotlin.exception

class ClienteNotFoundException(clienteId: Long) : RuntimeException("Cannot find Cliente $clienteId")