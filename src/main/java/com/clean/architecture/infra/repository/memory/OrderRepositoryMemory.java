package com.clean.architecture.infra.repository.memory;

import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.repository.OrderRepository;

import java.util.ArrayList;

public class OrderRepositoryMemory implements OrderRepository {

    ArrayList<Order> orders = new ArrayList<>();

    public OrderRepositoryMemory(){}

    @Override
    public void saveOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public Order getByCode(String code) {
        return null;
    }

    @Override
    public Integer count() {
        return orders.size();
    }
}
