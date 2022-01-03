package com.clean.architecture;

import java.util.ArrayList;

public class Order {

    private CPF cpf;
    private ArrayList<OrderItem> orderItems;
    private Coupon coupon;
    
    public Order(String cpf) throws Exception{
        this.cpf = new CPF(cpf);
        this.orderItems = new ArrayList<OrderItem>();
    }

    public void addItem(Item item, int quantity){
        this.orderItems.add(new OrderItem(item.idItem, item.price, quantity));
    }

    public double getTotal(){
        double total = 0;
        for(OrderItem orderItem: this.orderItems){
            total += orderItem.getTotal();
        }
        if(this.coupon != null){
            total -= (total * this.coupon.percentage) / 100;
        }
        return total;
    }

    public void addCoupon(Coupon coupon){
        this.coupon = coupon;
    }
}
