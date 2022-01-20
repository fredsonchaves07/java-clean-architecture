package com.clean.architecture.application.dto;

public class PlaceOrderOutput {

    private Double total;

    public PlaceOrderOutput(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }
}
