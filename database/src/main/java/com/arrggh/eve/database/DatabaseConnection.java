package com.arrggh.eve.database;

import com.arrggh.eve.database.executor.IConnectionExecutor;
import com.arrggh.eve.database.executor.IStatementExecutor;
import org.hsqldb.jdbc.JDBCDataSource;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private final DataSource datasource;
    private final DBI dbi;

    private DatabaseConnection(String url) throws SQLException {
        JDBCDataSource ds = new JDBCDataSource();
        ds.setUrl(url);
        ds.setUser("sa");
        ds.setPassword("");
        this.datasource = ds;
        this.dbi = new DBI(datasource);
    }

    public DatabaseConnection() throws SQLException {
        this("jdbc:hsqldb:mem:mymemdb");
    }

    public DatabaseConnection(File directory) throws SQLException {
        this("jdbc:hsqldb:file:" + directory.toString());
    }

    public void executeQuery(IConnectionExecutor executor) {
        try {
            executor.execute(datasource.getConnection());
        } catch (SQLException e) {
            throw new DatabaseException("Problem executing connection executor", e);
        }
    }

    public <T> T executeQuery(IStatementExecutor<T> executor) {
        try (Statement statement = datasource.getConnection().createStatement()) {
            try (ResultSet resultSet = executor.execute(statement)) {
                return executor.processResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Problem executing connection executor", e);
        }
    }

    public <T> void executeUpdate(IStatementExecutor<T> executor) {
        try (Statement statement = datasource.getConnection().createStatement()) {
            executor.execute(statement);
        } catch (SQLException e) {
            throw new DatabaseException("Problem executing connection executor", e);
        }
    }

    public <T> T getDao(Class<T> daoClass) {
        return dbi.onDemand(daoClass);
    }

    public void shutdown() {
        try {
            datasource.getConnection().close();
        } catch (SQLException e) {
            throw new DatabaseException("Cannot close database", e);
        }
    }
}