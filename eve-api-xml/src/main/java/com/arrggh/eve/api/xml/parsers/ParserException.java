package com.arrggh.eve.api.xml.parsers;

public class ParserException extends RuntimeException {
    public ParserException(String message, Exception cause) {
        super(message, cause);
    }
}
