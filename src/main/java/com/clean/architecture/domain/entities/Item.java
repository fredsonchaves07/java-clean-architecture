package com.clean.architecture.domain.entities;

public class Item {
    
    private String idItem;
    private String category;
    private String description;
    private double price;
    private double width;
    private double heigth;
    private double length;
    private double weight;

    public Item(String idItem, String category, String description, double price) {
        this.idItem = idItem;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Item(String idItem, String category, String description, double price, double width, double heigth, double length) {
        this.idItem = idItem;
        this.category = category;
        this.description = description;
        this.price = price;
        this.width = width;
        this.heigth = heigth;
        this.length = length;
    }

    public Item(String idItem, String category, String description, double price, double width, double heigth, double length, double weigth) {
        this.idItem = idItem;
        this.category = category;
        this.description = description;
        this.price = price;
        this.width = width;
        this.heigth = heigth;
        this.length = length;
        this.weight = weigth;
    }

    public String getIdItem() {
        return idItem;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getWidth() {
        return width;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getlength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return this.getWidth() / 100 * this.getHeigth() / 100 * this.getlength() / 100;
    }

    public double getDensity() {
        return this.getWeight() / this.getVolume();
    }

    public double getFreight() {
        double freight =  1000 * this.getVolume() * (this.getDensity() / 100);
        if(freight < 10){
            return  10;
        }
        return freight;
    }
}
