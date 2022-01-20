package com.clean.architecture.integration;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.dto.PlaceOrderOutput;
import com.clean.architecture.application.usecase.PlaceOrder;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.infra.repository.memory.ItemRepositoryMemory;
import com.clean.architecture.infra.repository.memory.OrderRepositoryMemory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {
    Order order;

    @Test
    public void shouldCreatePlaceOrder() throws Exception {
        List<ItemInput> items = new ArrayList<>();
        items.add(new ItemInput("1", 1));
        items.add(new ItemInput("2", 1));
        items.add(new ItemInput("3", 3));
        PlaceOrder placeOrder = new PlaceOrder(new ItemRepositoryMemory(), new OrderRepositoryMemory());
        PlaceOrderOutput output = placeOrder.execute(new PlaceOrderInput("847.903.332-05", items));
        assertEquals(6090, output.getTotal(), 0);
    }
}
