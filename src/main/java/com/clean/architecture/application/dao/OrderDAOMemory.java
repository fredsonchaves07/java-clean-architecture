package com.clean.architecture.application.dao;

import com.clean.architecture.application.query.OrderDTO;
import com.clean.architecture.application.query.OrderItemDTO;

import java.sql.SQLException;
import java.util.List;

public class OrderDAOMemory implements OrderDAO {

    @Override
    public List<OrderDTO> getOrders() {
        return null;
    }

    @Override
    public OrderDTO getOrder(String code) {
        return null;
    }

    @Override
    public List<OrderItemDTO> getOrderItems(Integer idOrder) {
        return null;
    }
}
