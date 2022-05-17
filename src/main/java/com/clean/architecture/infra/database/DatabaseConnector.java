package com.clean.architecture.infra.database;

import java.sql.SQLException;

public interface DatabaseConnector<T> {

    T query(String statement, Object[] params) throws SQLException;

    T query(String statement) throws SQLException;
}
