package com.clean.architecture;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private CPF cpf;
    private ArrayList<OrderItem> orderItems;
    private Coupon coupon;
    private LocalDate issueDate;
    private double freight;
    
    public Order(String cpf, LocalDate issueDate) throws Exception{
        this.cpf = new CPF(cpf);
        this.orderItems = new ArrayList<>();
        this.issueDate = issueDate;
    }

    public Order(String cpf) throws Exception{
        this.cpf = new CPF(cpf);
        this.orderItems = new ArrayList<>();
        this.issueDate = LocalDate.now();
    }

    public void addItem(Item item, int quantity){
        this.freight += item.getFreight() * quantity;
        this.orderItems.add(new OrderItem(item.getIdItem(), item.getPrice(), quantity));
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
        if(!coupon.isExpired(this.issueDate)){
            this.coupon = coupon;
        }
    }

    public double getFreight() {
        return this.freight;
    }
}
