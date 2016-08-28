package com.arrggh.eve.database;

import org.hsqldb.jdbc.JDBCDataSource;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

public class EveDatabase {
    private final DataSource datasource;
    private final DBI dbi;

    private EveDatabase(String url) throws SQLException {
        JDBCDataSource ds = new JDBCDataSource();
        ds.setUrl(url);
        ds.setUser("sa");
        ds.setPassword("");
        this.datasource = ds;
        this.dbi = new DBI(datasource);
    }

    public EveDatabase() throws SQLException {
        this("jdbc:hsqldb:mem:mymemdb");
    }

    public EveDatabase(File directory) throws SQLException {
        this("jdbc:hsqldb:mem:mymemdb");
    }

    public void execute(IConnectionExecutor executor) {
        try {
            executor.execute(datasource.getConnection());
        } catch (SQLException e) {
            throw new DatabaseException("Problem executing connection executor", e);
        }
    }

    public <T> T getDao(Class<T> daoClass) {
        return dbi.onDemand(daoClass);
    }
}