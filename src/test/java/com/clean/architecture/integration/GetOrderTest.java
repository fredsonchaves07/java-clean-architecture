package com.clean.architecture.integration;

import com.clean.architecture.application.dao.OrderDAO;
import com.clean.architecture.application.dao.OrderDAODatabase;
import com.clean.architecture.application.dto.GetOrderOutput;
import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.PlaceOrderInput;
import com.clean.architecture.application.query.GetOrdersQuery;
import com.clean.architecture.application.usecase.PlaceOrder;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.infra.database.DatabaseConnectionAdapter;
import com.clean.architecture.infra.database.DatabaseConnector;
import com.clean.architecture.infra.factory.DatabaseRepositoryFactory;
import com.clean.architecture.infra.repository.database.CouponRepositoryDatabase;
import com.clean.architecture.infra.repository.database.ItemRepositoryDatabase;
import com.clean.architecture.infra.repository.database.OrderRepositoryDatabase;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetOrderTest {

    PlaceOrder placeOrder;
    GetOrdersQuery getOrdersQuery;

    @Before
    public void init() throws SQLException {
        DatabaseConnector databaseConnection = new DatabaseConnectionAdapter();
        OrderDAO orderDAO = new OrderDAODatabase(databaseConnection);
        placeOrder = new PlaceOrder(new DatabaseRepositoryFactory(databaseConnection));
        getOrdersQuery = new GetOrdersQuery(orderDAO);
    }

    @Test
    public void shouldGetOrderByCode() throws Exception {
        List<ItemInput> items = new ArrayList<>();
        items.add(new ItemInput("1", 1));
        items.add(new ItemInput("2", 1));
        items.add(new ItemInput("3", 3));
        PlaceOrderInput placeOrderInput = new PlaceOrderInput(
                "847.903.332-05",
                items,
                LocalDate.of(2021, 10, 10),
                "VALE20"
        );
        placeOrder.execute(placeOrderInput);
        List<GetOrderOutput> getOrderOutput = getOrdersQuery.execute();
        System.out.println(getOrderOutput);
    }
}
