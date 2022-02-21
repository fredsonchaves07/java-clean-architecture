package com.clean.architecture.application.dto;

public class PlaceOrderOutput {

    private Double total;
    private String code;

    public PlaceOrderOutput(String code, Double total) {
        this.code = code;
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public String getCode() {
        return code;
    }
}
