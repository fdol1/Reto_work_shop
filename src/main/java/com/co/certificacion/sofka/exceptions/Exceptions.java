package com.co.certificacion.sofka.exceptions;

/**
 * Esta clase permite controlar errores inesperados
 */

public class Exceptions extends RuntimeException {

    public Exceptions() {
        super();
    }

    public Exceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Exceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public Exceptions(String message) {
        super(message);
    }

    public Exceptions(Throwable cause) {
        super(cause);
    }
}