package com.arrggh.eve.database.executor;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionExecutor {
    void execute(Connection connection) throws SQLException;
}
