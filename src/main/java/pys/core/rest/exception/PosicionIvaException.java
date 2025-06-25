package pys.core.rest.exception;

public class PosicionIvaException extends RuntimeException {

    public PosicionIvaException(Integer posicionIvaId) {
        super("Cannot find Posicion Iva: " + posicionIvaId);
    }

}
