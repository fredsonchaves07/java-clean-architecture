package com.clean.architecture.application.dto;

import com.clean.architecture.domain.entities.Order;

public class PlaceOrderOutputAssembler {

    public static PlaceOrderOutput assembly (Order order) {
        return new PlaceOrderOutput(order.getCode(), order.getTotal());
    }
}
