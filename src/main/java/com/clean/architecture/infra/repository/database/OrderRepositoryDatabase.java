package com.clean.architecture.infra.repository.database;

import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;
import com.clean.architecture.domain.entities.OrderItem;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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

    @Override
    public Order getByCode(String code) throws Exception {
        String orderId = null;
        Order order = null;
        ResultSet resultSet = databaseConnector.query("""
                SELECT * FROM ccca.order WHERE code = ?
                """, new Object[]{code});
        while (resultSet.next()) {
            orderId = resultSet.getString("id");
            order = new Order(resultSet.getString("cpf"), resultSet.getDate("issue_date").toLocalDate(), resultSet.getInt("sequence"));
        }
        resultSet = databaseConnector.query("""
                SELECT * FROM ccca.order_item WHERE id_order = ?
                """, new Object[]{orderId});
        while (resultSet.next()) {
            ResultSet itemData = databaseConnector.query("""
                    SELECT * FROM ccca.items WHERE id_item = ?
                    """, new Object[]{orderId});
            Item item;
            while (itemData.next()) {
                item = new Item(itemData.getString("id"), itemData.getString("category"), itemData.getString("description"), itemData.getDouble("price"), itemData.getDouble("width"), itemData.getDouble("height"), itemData.getDouble("length"), itemData.getDouble("weight"));
                order.addItem(item, itemData.getInt("quantity"));
            }
        }
        return order;
    }
}
