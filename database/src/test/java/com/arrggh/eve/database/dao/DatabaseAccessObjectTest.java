package com.arrggh.eve.database.dao;

import com.arrggh.eve.database.DatabaseConnection;
import com.arrggh.eve.database.DatabaseSchemaUpdator;
import org.junit.After;
import org.junit.Before;

import java.sql.SQLException;

public abstract class DatabaseAccessObjectTest {
    private DatabaseConnection connection;

    public <T> T getDao(Class<T> clazz) {
        return connection.getDao(clazz);
    }

    @Before
    public void buildDatabaseForTest() throws SQLException {
        this.connection = new DatabaseConnection();
        connection.executeQuery(new DatabaseSchemaUpdator());
    }

    @After
    public void shutdownDatabase() {
        connection.shutdown();
    }
}
