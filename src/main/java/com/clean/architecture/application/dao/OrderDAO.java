package com.clean.architecture.application.dao;

import com.clean.architecture.application.query.OrderDTO;
import com.clean.architecture.application.query.OrderItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    List<OrderDTO> getOrders() throws SQLException;

    OrderDTO getOrder(String code) throws SQLException;

    List<OrderItemDTO> getOrderItems(Integer idOrder) throws SQLException;
}
