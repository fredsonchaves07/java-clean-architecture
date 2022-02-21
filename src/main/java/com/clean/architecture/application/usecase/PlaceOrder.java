package com.clean.architecture.application.usecase;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.dto.PlaceOrderOutput;
import com.clean.architecture.application.dto.PlaceOrderOutputAssembler;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;

public class PlaceOrder {

    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    public PlaceOrder(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input, String vale20) throws Exception {
        Order order = new Order(input.getCpf(), input.getIssueDate(), 1);
        for (ItemInput orderItem : input.getItems()) {
            Item item = this.itemRepository.findById(orderItem.getIdItem());
            order.addItem(item, orderItem.getQuantity());
        }
        this.orderRepository.saveOrder(order);
        return PlaceOrderOutputAssembler.assembly(order);
    }
}
