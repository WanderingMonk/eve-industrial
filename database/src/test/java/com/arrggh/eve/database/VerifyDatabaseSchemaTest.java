package com.arrggh.eve.database;

import liquibase.exception.LiquibaseException;
import org.junit.Test;

import java.sql.SQLException;

public class VerifyDatabaseSchemaTest {
    @Test
    public void testDatabaseSchemaCanBeLoaded() throws SQLException, LiquibaseException {
        DatabaseConnection database = new DatabaseConnection();
        database.executeQuery(new DatabaseSchemaUpdator());
    }
}
