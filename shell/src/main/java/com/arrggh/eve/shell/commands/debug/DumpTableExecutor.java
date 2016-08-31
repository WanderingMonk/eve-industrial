package com.arrggh.eve.shell.commands.debug;

import com.arrggh.eve.database.executor.IStatementExecutor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DumpTableExecutor implements IStatementExecutor<List<List<String>>> {
    private String tablename;

    public DumpTableExecutor(String tablename) {
        this.tablename = tablename;
    }

    @Override
    public ResultSet execute(Statement statement) throws SQLException {
        return statement.executeQuery("SELECT * FROM " + tablename);
    }

    @Override
    public List<List<String>> processResultSet(ResultSet resultSet) throws SQLException {
        List<List<String>> results = new LinkedList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();

        List<String> headers = new LinkedList<>();
        for (int hc = 0; hc != columns; hc++) {
            headers.add(limit(metaData.getColumnName(hc + 1)));
        }
        results.add(headers);

        List<String> dashes = new LinkedList<>();
        for (int hc = 0; hc != columns; hc++) {
            dashes.add(limit("--------------------------------------"));
        }
        results.add(dashes);

        while (resultSet.next()) {
            List<String> row = new LinkedList<>();
            for (int c = 0; c != columns; c++) {
                row.add(limit(resultSet.getString(c + 1)));
            }
            results.add(row);
        }

        List<String> footer = new LinkedList<>();
        for (int hc = 0; hc != columns; hc++) {
            footer.add(limit("--------------------------------------"));
        }
        results.add(footer);

        return results;
    }

    private static final int LIMIT = 15;

    private static String limit(String text) {
        if (text.length() > LIMIT) {
            return text.substring(0, LIMIT);
        }
        return text;
    }
}
