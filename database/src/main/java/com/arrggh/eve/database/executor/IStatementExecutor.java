package com.arrggh.eve.database.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IStatementExecutor<T> {
    ResultSet execute(Statement statement) throws SQLException;

    T processResultSet(ResultSet resultSet) throws SQLException;
}
