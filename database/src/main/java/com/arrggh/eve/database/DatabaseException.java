package com.arrggh.eve.database;

import java.sql.SQLException;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
