package com.clean.architecture.domain.entities;

public class OrderItem {
    
    public String idItem;
    public double price;
    public int quantity;

    public OrderItem(String idItem, double price, int quantity){
        this.idItem = idItem;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal(){
        return this.price * this.quantity;
    }
}
