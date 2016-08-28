package com.arrggh.eve.database;

import liquibase.exception.LiquibaseException;
import org.junit.Test;

import java.sql.SQLException;

public class VerifyDatabaseSchemaTest {
    @Test
    public void testDatabaseSchemaCanBeLoaded() throws SQLException, LiquibaseException {
        EveDatabase database = new EveDatabase();
        database.execute(new DatabaseSchemaUpdator());
    }
}
