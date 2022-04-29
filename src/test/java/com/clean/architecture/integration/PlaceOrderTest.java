package com.clean.architecture.integration;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.dto.PlaceOrderOutput;
import com.clean.architecture.application.query.GetOrdersQuery;
import com.clean.architecture.application.usecase.PlaceOrder;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.infra.database.DatabaseConnectionAdapter;
import com.clean.architecture.infra.database.DatabaseConnector;
import com.clean.architecture.infra.factory.DatabaseRepositoryFactory;
import com.clean.architecture.infra.repository.database.CouponRepositoryDatabase;
import com.clean.architecture.infra.repository.database.OrderRepositoryDatabase;
import com.clean.architecture.infra.repository.database.ItemRepositoryDatabase;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {

    PlaceOrder placeOrder;

    @Before
    public void init() throws SQLException {
        DatabaseConnector databaseConnection = new DatabaseConnectionAdapter();
        placeOrder = new PlaceOrder(new DatabaseRepositoryFactory(databaseConnection));
    }

    @Test
    public void shouldCreatePlaceOrder() throws Exception {
        List<ItemInput> items = new ArrayList<>();
        items.add(new ItemInput("1", 1));
        items.add(new ItemInput("2", 1));
        items.add(new ItemInput("3", 3));
        PlaceOrderOutput output = placeOrder.execute(new PlaceOrderInput("847.903.332-05", items, LocalDate.of(2021, 10, 10), "VALE20"));
        assertEquals(4872, output.getTotal(), 0);
    }
}
