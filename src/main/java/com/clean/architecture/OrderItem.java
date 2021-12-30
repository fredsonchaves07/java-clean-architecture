package com.clean.architecture;

public class OrderItem {
    
    public String idItem;
    public double price;
    public int quantity;

    public OrderItem(String idItem, double price, int quantity){
        this.idItem = idItem;
        this.price = price;
        this.quantity = quantity;
    }
}
