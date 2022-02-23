package com.clean.architecture.application.usecase;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.dto.PlaceOrderOutput;
import com.clean.architecture.application.dto.PlaceOrderOutputAssembler;
import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;

public class PlaceOrder {

    private ItemRepository itemRepository;
    private OrderRepository orderRepository;
    private CouponRepository couponRepository;

    public PlaceOrder(ItemRepository itemRepository, OrderRepository orderRepository, CouponRepository couponRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.couponRepository = couponRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) throws Exception {
        Order order = new Order(input.getCpf(), input.getIssueDate(), 1);
        for (ItemInput orderItem : input.getItems()) {
            Item item = this.itemRepository.findById(orderItem.getIdItem());
            order.addItem(item, orderItem.getQuantity());
        }
        if (input.getCoupon() != null) {
            Coupon coupon = couponRepository.findByCode(input.getCoupon());
            order.addCoupon(coupon);
        }
        this.orderRepository.saveOrder(order);
        return PlaceOrderOutputAssembler.assembly(order);
    }
}
