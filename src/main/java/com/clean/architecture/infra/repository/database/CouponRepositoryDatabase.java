package com.clean.architecture.infra.repository.database;

import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class CouponRepositoryDatabase implements CouponRepository {

    private DatabaseConnector databaseConnector;

    public CouponRepositoryDatabase(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Coupon findByCode(String codItem) throws SQLException {
        Coupon coupon = null;
        ResultSet resultSet = databaseConnector.query("SELECT * FROM ccca.coupon WHERE code =?", new String[]{codItem});
        while (resultSet.next()) {
            coupon = new Coupon(resultSet.getString("code"), resultSet.getInt("percentage"), resultSet.getDate("expire_date").toLocalDate());
        }
        return coupon;
    }
}
