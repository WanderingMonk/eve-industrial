package com.arrggh.eve.utilities.exceptions;

public class ParserException extends RuntimeException {
    public ParserException(String message, Exception cause) {
        super(message, cause);
    }
}
