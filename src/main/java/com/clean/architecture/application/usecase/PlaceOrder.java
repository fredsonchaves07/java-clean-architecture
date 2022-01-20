package com.clean.architecture.application.usecase;

import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.entities.OrderItem;

public class PlaceOrder {

    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    public PlaceOrder(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public double execute(input) {
        Order order = new Order(input.cpf);
        for (OrderItem orderItem : input.orderItems) {
            Item item = this.itemRepository.findById(orderItem.idItem);
            order.addItem(item, orderItem.quantity);
        }
        this.orderRepository.saveOrder(order);
        return order.getTotal();
    }
}
