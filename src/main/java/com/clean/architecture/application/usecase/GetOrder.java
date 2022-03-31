package com.clean.architecture.application.usecase;

import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.repository.OrderRepository;

public class GetOrder {

    private OrderRepository orderRepository;

    public GetOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void execute(String code) {
        Order order = orderRepository.getByCode(code);
    }
}
