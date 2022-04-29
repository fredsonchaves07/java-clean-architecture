package com.clean.architecture.application.usecase;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.dto.PlaceOrderOutput;
import com.clean.architecture.application.dto.PlaceOrderOutputAssembler;
import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.factory.AbstractRepositoryFactory;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.service.FreightCalculator;

public class PlaceOrder {

    private ItemRepository itemRepository;
    private OrderRepository orderRepository;
    private CouponRepository couponRepository;

    public PlaceOrder(AbstractRepositoryFactory  abstractRepositoryFactory){
        this.itemRepository = abstractRepositoryFactory.createItemRepository();
        this.orderRepository = abstractRepositoryFactory.createOrderRepository();
        this.couponRepository = abstractRepositoryFactory.createCuponRepository();
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) throws Exception {
        Integer sequence = orderRepository.count();
        Order order = new Order(input.getCpf(), input.getIssueDate(), ++sequence);
        Double freight = 0.0;
        for (ItemInput orderItem : input.getItems()) {
            Item item = this.itemRepository.findById(orderItem.getIdItem());
            freight += FreightCalculator.calculate(item) * orderItem.getQuantity();
            order.addItem(item, orderItem.getQuantity());
        }
        order.setFreight(freight);
        if (input.getCoupon() != null) {
            Coupon coupon = couponRepository.findByCode(input.getCoupon());
            order.addCoupon(coupon);
        }
        this.orderRepository.saveOrder(order);
        return PlaceOrderOutputAssembler.assembly(order);
    }
}
