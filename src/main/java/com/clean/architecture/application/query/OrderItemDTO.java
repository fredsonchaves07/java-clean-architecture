package com.clean.architecture.application.query;

public class OrderItemDTO {

    private String description;

    private Integer quantity;

    private Double price;

    public OrderItemDTO(String description, Integer quantity, Double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
}
