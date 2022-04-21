package com.clean.architecture.application.dto;

public class ItemOutput {

    private String description;
    private Integer quantity;
    private Double price;

    public ItemOutput(String description, Integer quantity, Double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "item: " + description;
    }
}
