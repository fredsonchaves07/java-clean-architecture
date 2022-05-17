package com.clean.architecture.infra.repository.database;

import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.infra.database.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemRepositoryDatabase implements ItemRepository {

    private DatabaseConnector databaseConnector;

    public ItemRepositoryDatabase(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Item findById(String idItem) throws SQLException {
        Item item = null;
        ResultSet resultSet = (ResultSet) databaseConnector.query("SELECT * FROM ccca.item WHERE id =?", new Integer[]{Integer.parseInt(idItem)});
        while (resultSet.next()) {
            item = new Item(resultSet.getString("id"), resultSet.getString("category"), resultSet.getString("description"), resultSet.getDouble("price"), resultSet.getDouble("width"), resultSet.getDouble("height"), resultSet.getDouble("length"), resultSet.getDouble("weight"));
        }
        return item;
    }
}
