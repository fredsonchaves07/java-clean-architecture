package com.clean.architecture.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import com.clean.architecture.domain.entities.Coupon;
import org.junit.Test;

public class CouponTest {
    
    @Test
    public void shouldCreateCouponValid(){
        Coupon coupon = new Coupon("VALE20", 20, LocalDate.of(2022, 01, 15));
        boolean isExpired = coupon.isExpired(LocalDate.of(2022, 01, 01));
        assertFalse(isExpired);
    }

    @Test
    public void shouldCreateCouponInvalid(){
        Coupon coupon = new Coupon("VALE20", 20, LocalDate.of(2022, 01, 01));
        boolean isExpired = coupon.isExpired(LocalDate.of(2022, 01, 15));
        assertTrue(isExpired);
    }

    @Test
    public void shouldCreateCouponNeverExpire(){
        Coupon coupon = new Coupon("VALE20", 20);
        boolean isExpired = coupon.isExpired(LocalDate.of(2022, 01, 15));
        assertFalse(isExpired);
    }
}
