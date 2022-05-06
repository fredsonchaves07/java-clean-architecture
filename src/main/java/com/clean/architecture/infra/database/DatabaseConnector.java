package com.clean.architecture.infra.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public interface DatabaseConnector {

    ResultSet query(String statement, Object[] params) throws SQLException;

    default Properties loadProperties() {
        String urlFile = "src/main/resources/db.properties";
        try (FileInputStream fileInputStream = new FileInputStream(urlFile)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException error) {
            throw new Error(error.getMessage());
        }
    }

    default void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException error) {
                throw new Error(error.getMessage());
            }
        }
    }

    default void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException eror) {
                throw new Error(eror.getMessage());
            }
        }
    }
}
