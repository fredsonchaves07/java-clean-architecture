package com.clean.architecture.infra.repository.memory;

import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.repository.CouponRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CouponRepositoryMemory implements CouponRepository {

    List<Coupon> coupons = new ArrayList<>();

    @Override
    public Coupon findByCode(String code) {
        Coupon item = coupons.stream().filter(coupon -> Objects.equals(coupon.getCode(), code)).findAny().orElse(null);
        if (item == null) throw new RuntimeException("Coupon not found");
        return item;
    }
}
