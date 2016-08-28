package com.arrggh.eve.database;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseSchemaUpdator implements IConnectionExecutor {
    @Override
    public void execute(Connection connection) throws SQLException {
        try {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase("database-changelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts());
        } catch (LiquibaseException e) {
            throw new SQLException("Cannot update schema", e);
        }
    }
}
