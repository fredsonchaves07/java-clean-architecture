package com.clean.architecture.application.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetOrderOutput {

    private String code;
    private String cpf;
    private List<ItemOutput> items;
    private Double total;
    private Double freight;

    public GetOrderOutput(String code, String cpf, List<ItemOutput> items, Double total, Double freight) {
        this.code = code;
        this.cpf = cpf;
        this.items = items;
        this.total = total;
        this.freight = freight;
    }

    public Double getTotal() {
        return total;
    }

    public Double getFreight() {
        return freight;
    }

    @Override
    public String toString() {
        return "code: " + code + " cpf: " + cpf + " items: " + items + " total: " + total + " freight: " + freight;
    }
}
