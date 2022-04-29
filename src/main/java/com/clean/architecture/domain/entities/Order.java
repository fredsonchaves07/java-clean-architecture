package com.clean.architecture.domain.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private CPF cpf;
    private ArrayList<OrderItem> orderItems;
    private Coupon coupon;
    private LocalDate issueDate;
    private double freight;
    private OrderCode code;
    
    public Order(String cpf, LocalDate issueDate, Integer sequence) throws Exception{
        this.cpf = new CPF(cpf);
        this.code = new OrderCode(issueDate, sequence);
        this.orderItems = new ArrayList<>();
        this.issueDate = issueDate;
    }

    public Order(String cpf, LocalDate issueDate) throws Exception {
        this.cpf = new CPF(cpf);
        this.code = new OrderCode(issueDate, 1);
        this.orderItems = new ArrayList<>();
        this.issueDate = issueDate;
    }

    public Order(String cpf) throws Exception{
        this.cpf = new CPF(cpf);
        this.orderItems = new ArrayList<>();
        this.issueDate = LocalDate.now();
        this.code = new OrderCode(this.issueDate, 1);
    }

    public void addItem(Item item, int quantity){
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

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getCode() {
        return code.getCode();
    }

    public String getCpf() {
        return cpf.getCpf();
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getCoupon() {
        return coupon.toString();
    }

    public Integer getSequence() {
        return code.getSequence();
    }

    public ArrayList<OrderItem> getOrderItems() {
        return this.orderItems;
    }
}
