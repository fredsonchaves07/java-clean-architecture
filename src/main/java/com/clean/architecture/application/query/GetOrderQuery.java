package com.clean.architecture.application.query;

import com.clean.architecture.application.dto.GetOrderOutput;
import com.clean.architecture.application.dto.ItemOutput;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetOrderQuery {

    private DatabaseConnector databaseConnector;

    public GetOrderQuery(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public GetOrderOutput execute(String code) throws SQLException {
        GetOrderOutput getOrderOutput = null;
        List<ItemOutput> items = new ArrayList<>();
        ResultSet resultSetOrder =  databaseConnector.query("SELECT id, code, cpf FROM ccca.order WHERE code = ?", new String[] {code});
        while (resultSetOrder.next()) {
            ResultSet resultSetItems = databaseConnector.query("" +
                    "SELECT i.description, oi.quantity, oi.price " +
                    "FROM ccca.order_item oi " +
                    "JOIN ccca.item i ON (oi.id_item = i.id) " +
                    "WHERE id_order = ?", new Integer[] {resultSetOrder.getInt("id")});
            while (resultSetItems.next()) {
                items.add(new ItemOutput(
                        resultSetItems.getString("description"),
                        resultSetItems.getInt("quantity"),
                        resultSetItems.getDouble("price")
                ));
            }
            getOrderOutput = new GetOrderOutput(
                    resultSetOrder.getString("code"),
                    resultSetOrder.getString("cpf"),
                    items
            );
        }
        return getOrderOutput;
    }
}
