package com.clean.architecture.infra.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseConnector {

    ResultSet query(String statement, Object[] params) throws SQLException;
}
