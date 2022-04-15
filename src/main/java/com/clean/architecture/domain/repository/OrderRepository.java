package com.clean.architecture.domain.repository;

import com.clean.architecture.domain.entities.Order;

import java.sql.SQLException;

public interface OrderRepository {

    void saveOrder(Order order) throws SQLException;
    Integer count() throws SQLException;
    Order getByCode(String code);
}
