package com.clean.architecture.integration;

import com.clean.architecture.application.usecase.PlaceOrder;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.infra.repository.memory.ItemRepositoryMemory;
import com.clean.architecture.infra.repository.memory.OrderRepositoryMemory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {
    Order order;

    @Test
    public void shouldCreatePlaceOrder() throws Exception {
        PlaceOrder placeOrder = new PlaceOrder(new ItemRepositoryMemory(), new OrderRepositoryMemory());
        output = placeOrder.execute(input);
        assertEquals(6090, output.getTotal(), 0);
    }
}
