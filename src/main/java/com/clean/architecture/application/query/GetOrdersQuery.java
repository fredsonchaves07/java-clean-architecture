package com.clean.architecture.application.query;

import com.clean.architecture.application.dto.GetOrderOutput;
import com.clean.architecture.application.dto.ItemOutput;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetOrdersQuery {

    private DatabaseConnector databaseConnector;

    public GetOrdersQuery(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public List<GetOrderOutput> execute() throws SQLException {




        List<GetOrderOutput> getOrdersOutput = new ArrayList<>();
        GetOrderOutput getOrderOutput;
        List<ItemOutput> items = new ArrayList<>();
        ResultSet resultSetOrder = (ResultSet) databaseConnector.query("SELECT id, code, cpf, total, freight FROM ccca.order", new Object[]{});
        while (resultSetOrder.next()) {
            ResultSet resultSetItems = (ResultSet) databaseConnector.query("" +
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
                    items,
                    resultSetOrder.getDouble("total"),
                    resultSetOrder.getDouble("freight")
            );
            getOrdersOutput.add(getOrderOutput);
        }
        return getOrdersOutput;
    }
}
