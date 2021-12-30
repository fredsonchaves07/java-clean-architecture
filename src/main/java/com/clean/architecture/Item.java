package com.clean.architecture;

public class Item {
    
    public String idItem;
    public String category;
    public String description;
    public double price;

    public Item(String idItem, String category, String description, double price){
        this.idItem = idItem;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}
