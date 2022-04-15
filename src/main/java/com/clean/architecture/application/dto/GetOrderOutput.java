package com.clean.architecture.application.dto;

import java.util.ArrayList;
import java.util.List;

public class GetOrderOutput {

    private String code;
    private String cpf;
    private List<ItemOutput> items;

    public GetOrderOutput(String code, String cpf, List<ItemOutput> items) {
        this.code = code;
        this.cpf = cpf;
        this.items = items;
    }
}
