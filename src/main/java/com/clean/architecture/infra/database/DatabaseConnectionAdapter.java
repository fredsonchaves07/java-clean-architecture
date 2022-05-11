package com.clean.architecture.infra.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseConnectionAdapter implements DatabaseConnector {

    Properties properties = loadProperties();

    String dbUrl = properties.getProperty("dburl");

    String user = properties.getProperty("user");

    String password = properties.getProperty("password");

    private Connection connection;

    public DatabaseConnectionAdapter() throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    private Properties loadProperties() {
        String urlFile = "src/main/resources/db.properties";
        try (FileInputStream fileInputStream = new FileInputStream(urlFile)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException error) {
            throw new Error(error.getMessage());
        }
    }

    @Override
    public ResultSet query(String statement, Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        for (int i = 0; i < params.length; i ++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeQuery();
    }

    public void closeStatement(Statement statement) throws SQLException {
        if (statement != null) statement.close();
    }

    public void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
    }
}
