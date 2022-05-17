package com.clean.architecture.application.dto;

import com.clean.architecture.application.query.OrderItemDTO;

import java.util.List;

public class GetOrderOutput {

    private String code;
    private String cpf;
    private List<OrderItemDTO> items;
    private Double total;
    private Double freight;

    public GetOrderOutput(String code, String cpf, List<OrderItemDTO> items, Double total, Double freight) {
        this.code = code;
        this.cpf = cpf;
        this.items = items;
        this.total = total;
        this.freight = freight;
    }

    @Override
    public String toString() {
        return "code: " + code + " cpf: " + cpf + " items: " + items + " total: " + total + " freight: " + freight;
    }
}
