package com.arrggh.eve.database;

import com.arrggh.eve.database.executor.IStatementExecutor;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {
    @Test
    public void testDatabaseConnection() throws SQLException {
        DatabaseConnection database = new DatabaseConnection();
        database.executeQuery(new DatabaseSchemaUpdator());

        String value = database.executeQuery(new IStatementExecutor<String>(){
            @Override
            public ResultSet execute(Statement statement) throws SQLException {
                return statement.executeQuery("SELECT * FROM  INFORMATION_SCHEMA.TABLES");
            }

            @Override
            public String processResultSet(ResultSet resultSet) throws SQLException {
                resultSet.next();
                return resultSet.getString(1);
            }
        });

        assertEquals("PUBLIC", value);
    }

}