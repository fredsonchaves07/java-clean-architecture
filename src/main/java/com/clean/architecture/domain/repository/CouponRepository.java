package com.clean.architecture.domain.repository;

import com.clean.architecture.domain.entities.Coupon;

import java.sql.SQLException;

public interface CouponRepository {

    Coupon findByCode(String codItem) throws SQLException;
}
