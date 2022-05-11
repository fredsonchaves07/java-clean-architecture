package com.clean.architecture.application.query;

public class OrderDTO {

    private Integer id;

    private String code;

    private String cpf;

    private Double freight;

    private Double total;

    public OrderDTO(Integer id, String code, String cpf, Double freight, Double total) {
        this.id = id;
        this.code = code;
        this.cpf = cpf;
        this.freight = freight;
        this.total = total;
    }
}
