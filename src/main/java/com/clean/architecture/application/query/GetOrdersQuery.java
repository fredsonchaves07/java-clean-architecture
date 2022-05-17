package com.clean.architecture.application.query;

import com.clean.architecture.application.dao.OrderDAO;
import com.clean.architecture.application.dto.GetOrderOutput;
import com.clean.architecture.application.dto.ItemOutput;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetOrdersQuery {

    private OrderDAO orderDAO;

    public GetOrdersQuery(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<GetOrderOutput> execute() throws SQLException {
        List<OrderDTO> orderDTOS =  orderDAO.getOrders();
        List<GetOrderOutput> orderOutputs = new ArrayList<>();
        for (OrderDTO orderDTO : orderDTOS) {
            List<OrderItemDTO> orderItemDTOS = orderDAO.getOrderItems(orderDTO.getId());
            orderOutputs.add(new GetOrderOutput(
                    orderDTO.getCode(), orderDTO.getCpf(), orderItemDTOS, orderDTO.getFreight(), orderDTO.getTotal()
            ));
        }
        return orderOutputs;
    }
}
