package com.clean.architecture;

import java.util.ArrayList;

public class Order {
    CPF cpf;
    ArrayList<OrderItem> orderItems;
    
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
            total += orderItem.price * orderItem.quantity;
        }
        return total;
    }
}
