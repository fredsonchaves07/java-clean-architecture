package com.clean.architecture.domain.entities;


import java.time.LocalDate;

public class Coupon {
    
    String code;
    int percentage;
    LocalDate expireDate;

    public Coupon(String code, int percentage, LocalDate date){
        this.code = code;
        this.percentage = percentage;
        this.expireDate = date;
    }

    public Coupon(String code, int percentage){
        this.code = code;
        this.percentage = percentage;
    }

    public boolean isExpired(LocalDate today){
        if(this.expireDate == null){
            return false;
        }
        return this.expireDate.isBefore(today);
    }
}
