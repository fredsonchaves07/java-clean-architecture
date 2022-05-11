package com.clean.architecture.application.dao;

import com.clean.architecture.application.query.OrderDAO;
import com.clean.architecture.application.query.OrderDTO;
import com.clean.architecture.application.query.OrderItemDTO;

import java.util.List;

public class OrderDAODatabase implements OrderDAO {

    private

    @Override
    public List<OrderDTO> getOrders() {
        return null;
    }

    @Override
    public OrderDTO getOrder() {
        return null;
    }

    @Override
    public OrderItemDTO getOrderItems(Integer idOrder) {
        return null;
    }
}
