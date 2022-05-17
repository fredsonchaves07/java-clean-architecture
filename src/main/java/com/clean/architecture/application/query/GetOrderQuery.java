package com.clean.architecture.application.query;

import com.clean.architecture.application.dao.OrderDAO;
import com.clean.architecture.application.dto.GetOrderOutput;
import com.clean.architecture.application.dto.ItemOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetOrderQuery {

    private OrderDAO orderDAO;

    public GetOrderQuery(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public GetOrderOutput execute(String code) throws SQLException {
        OrderDTO orderData = orderDAO.getOrder(code);
        List<OrderItemDTO> orderItemsData = orderDAO.getOrderItems(orderData.getId());
        return new GetOrderOutput(
                orderData.getCode(), orderData.getCpf(), orderItemsData, orderData.getFreight(), orderData.getTotal()
        );
    }
}
