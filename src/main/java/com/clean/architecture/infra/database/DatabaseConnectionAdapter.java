package com.clean.architecture.infra.database;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnectionAdapter implements DatabaseConnector{

    private String url = "jdbc:postgresql://localhost:5432/ccca";
    private String user = "postgres";
    private String password = "1234";
    private Connection connection;

    public DatabaseConnectionAdapter() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public ResultSet query(String statement, Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        for (int i = 0; i < params.length; i ++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeQuery();
    }
}
