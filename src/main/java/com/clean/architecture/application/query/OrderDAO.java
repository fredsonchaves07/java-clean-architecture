package com.clean.architecture.application.query;

import java.util.List;

public interface OrderDAO {

    List<OrderDTO> getOrders();

    OrderDTO getOrder();

    OrderItemDTO getOrderItems(Integer idOrder);
}
