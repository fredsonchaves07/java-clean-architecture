package com.clean.architecture.infra.repository.memory;

import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.infra.database.DatabaseConnector;

public class ItemRepositoryDatabase implements ItemRepository {

    private DatabaseConnector databaseConnector;

    public ItemRepositoryDatabase(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Item findById(String idItem) {
        return null;
    }
}
