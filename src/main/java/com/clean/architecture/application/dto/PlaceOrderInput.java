package com.clean.architecture.application.dto;

import java.util.List;

public class PlaceOrderInput {

    private String cpf;
    private List<ItemInput> items;
    private String coupon;

    public PlaceOrderInput(String cpf, List<ItemInput> items, String coupon) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
    }

    public PlaceOrderInput(String cpf, List<ItemInput> items) {
        this.cpf = cpf;
        this.items = items;
    }

    public String getCpf() {
        return cpf;
    }

    public List<ItemInput> getItems() {
        return items;
    }
}
