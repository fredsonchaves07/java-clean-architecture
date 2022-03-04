package com.clean.architecture.integration;

import com.clean.architecture.application.usecase.ValidateCoupon;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.infra.database.DatabaseConnectionAdapter;
import com.clean.architecture.infra.database.DatabaseConnector;
import com.clean.architecture.infra.repository.database.CouponRepositoryDatabase;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class ValidateCouponTest {

    DatabaseConnector databaseConnector = new DatabaseConnectionAdapter();
    CouponRepository couponRepository = new CouponRepositoryDatabase(databaseConnector);

    public ValidateCouponTest() throws SQLException {
    }


    @Test
    public void shouldValidateCoupon() throws SQLException {
        ValidateCoupon validateCoupon = new ValidateCoupon(couponRepository);
        assertTrue(validateCoupon.execute("VALE20", LocalDate.of(2022, 2, 23)));
    }
}
