package com.clean.architecture.domain.entities;

import java.time.LocalDate;

public class OrderCode {

    private LocalDate date;
    private Integer sequence;

    public OrderCode(LocalDate date, Integer sequence) {
        this.date = date;
        this.sequence = sequence;
    }

    public String getCode() {
        Integer year = date.getYear();
        String sequence8Char = String.format("%08d", sequence);
        return year + sequence8Char;
    }
}
