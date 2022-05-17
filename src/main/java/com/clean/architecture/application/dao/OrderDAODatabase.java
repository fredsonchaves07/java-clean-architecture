package com.clean.architecture.application.dao;

import com.clean.architecture.application.query.OrderDTO;
import com.clean.architecture.application.query.OrderItemDTO;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TODO -> Implementar o fechamento das conexões e statement
public class OrderDAODatabase implements OrderDAO {

    private DatabaseConnector databaseConnector;

    public OrderDAODatabase(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public List<OrderDTO> getOrders() throws SQLException {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        ResultSet resultSetOrder = (ResultSet) databaseConnector.query(
                "SELECT id, code, cpf, total, freight FROM ccca.order"
        );
        while (resultSetOrder.next()) {
            orderDTOS.add(new OrderDTO(
                    resultSetOrder.getInt("id"),
                    resultSetOrder.getString("code"),
                    resultSetOrder.getString("cpf"),
                    resultSetOrder.getDouble("total"),
                    resultSetOrder.getDouble("freight")
            ));
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO getOrder(String code) throws SQLException {
        OrderDTO orderDTO = null;
        ResultSet resultSetOrder = (ResultSet) databaseConnector.query(
                "SELECT id, code, cpf, total, freight FROM ccca.order WHERE code = ?",
                new String[]{code}
        );
        while (resultSetOrder.next()) {
            orderDTO = new OrderDTO(
                    resultSetOrder.getInt("id"),
                    resultSetOrder.getString("code"),
                    resultSetOrder.getString("cpf"),
                    resultSetOrder.getDouble("total"),
                    resultSetOrder.getDouble("freight")
            );
        }
        return orderDTO;
    }

    @Override
    public List<OrderItemDTO> getOrderItems(Integer idOrder) throws SQLException {
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        ResultSet resultSetItems = (ResultSet) databaseConnector.query("" +
                "SELECT i.description, oi.quantity, oi.price " +
                "FROM ccca.order_item oi " +
                "JOIN ccca.item i ON (oi.id_item = i.id) " +
                "WHERE id_order = ?", new Integer[] {idOrder});
        while (resultSetItems.next()) {
            orderItemDTOS.add(new OrderItemDTO(
                    resultSetItems.getString("description"),
                    resultSetItems.getInt("quantity"),
                    resultSetItems.getDouble("price")
            ));
        }
        return orderItemDTOS;
    }
}
