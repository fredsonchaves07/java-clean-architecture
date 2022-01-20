package com.clean.architecture.infra.database;

public interface DatabaseConnector {

    void query(String statement, String params);
}
