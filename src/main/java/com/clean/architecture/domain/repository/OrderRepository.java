package com.clean.architecture.domain.repository;

import com.clean.architecture.domain.entities.Order;

public interface OrderRepository {

    void saveOrder(Order order);
}
