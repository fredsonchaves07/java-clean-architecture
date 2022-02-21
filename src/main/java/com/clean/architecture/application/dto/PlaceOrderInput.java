package com.clean.architecture.application.dto;

import java.time.LocalDate;
import java.util.List;

public class PlaceOrderInput {

    private String cpf;
    private List<ItemInput> items;
    private String coupon;
    private LocalDate issueDate;
    private Integer sequence;

    public PlaceOrderInput(String cpf, List<ItemInput> items, String coupon, LocalDate issueDate, Integer sequence) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
        this.issueDate = issueDate;
        this.sequence = sequence;
    }

    public PlaceOrderInput(String cpf, List<ItemInput> items, LocalDate issueDate) {
        this.cpf = cpf;
        this.items = items;
        this.issueDate = issueDate;
    }

    public PlaceOrderInput(String cpf, List<ItemInput> items, LocalDate issueDate, String coupon) {
        this.cpf = cpf;
        this.items = items;
        this.issueDate = issueDate;
        this.coupon = coupon;
    }

    public PlaceOrderInput(String cpf, List<ItemInput> items, String coupon, Integer sequence) {
        this.cpf = cpf;
        this.items = items;
        this.coupon = coupon;
        this.issueDate = LocalDate.now();
        this.sequence = sequence;
    }

    public String getCpf() {
        return cpf;
    }

    public List<ItemInput> getItems() {
        return items;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }
}
