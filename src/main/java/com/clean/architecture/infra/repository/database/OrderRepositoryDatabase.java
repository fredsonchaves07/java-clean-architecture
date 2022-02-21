package com.clean.architecture.infra.repository.database;

import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.entities.OrderItem;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryDatabase implements OrderRepository {

    private DatabaseConnector databaseConnector;

    public OrderRepositoryDatabase(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public void saveOrder(Order order) throws SQLException {
        ResultSet resultSet = databaseConnector.query("""
        INSERT INTO ccca.order (code, cpf, issue_date, freight, sequence, coupon)
        VALUES (?, ?, ?, ?, ?, ?) RETURNING *
        """, new Object[]{
                order.getCode(),
                order.getCpf(),
                order.getIssueDate(),
                order.getFreight(),
                order.getSequence(),
                order.getCoupon()
        });
        while (resultSet.next()) {
            for(OrderItem orderItem : order.getOrderItems()) {
                databaseConnector.query("""
                INSERT INTO ccca.order_item (id_order, id_item, price, quantity)
                VALUES(?, ?, ?, ?) RETURNING *
            """,
            new Object[] {resultSet.getInt("id"), Integer.parseInt(orderItem.idItem), orderItem.price, orderItem.quantity});
            }
        }

    }
}
