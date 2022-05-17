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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
