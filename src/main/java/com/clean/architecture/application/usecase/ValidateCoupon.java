package com.clean.architecture.application.usecase;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.SimulateFreightInput;
import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;

import java.sql.SQLException;
import java.time.LocalDate;

public class ValidateCoupon {

    private CouponRepository couponRepository;

    public ValidateCoupon(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public boolean execute(String code, LocalDate date) throws SQLException {
        Coupon coupon = couponRepository.findByCode(code);
        return coupon.isValid(date);
    }
}
