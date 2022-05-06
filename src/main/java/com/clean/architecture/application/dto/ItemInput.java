package com.clean.architecture.application.dto;

public class ItemInput {

    private String idItem;
    private Integer quantity;

    public ItemInput(String codItem, Integer quantity) {
        this.idItem = codItem;
        this.quantity = quantity;
    }

    public String getIdItem() {
        return idItem;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
