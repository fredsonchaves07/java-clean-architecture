package com.clean.architecture.infra.factory;

import com.clean.architecture.domain.factory.AbstractRepositoryFactory;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.infra.database.DatabaseConnector;
import com.clean.architecture.infra.repository.database.CouponRepositoryDatabase;
import com.clean.architecture.infra.repository.database.ItemRepositoryDatabase;
import com.clean.architecture.infra.repository.database.OrderRepositoryDatabase;

public class DatabaseRepositoryFactory implements AbstractRepositoryFactory {

    private final DatabaseConnector databaseConnector;

    public DatabaseRepositoryFactory(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public ItemRepository createItemRepository() {
        return new ItemRepositoryDatabase(databaseConnector);
    }

    @Override
    public CouponRepository createCuponRepository() {
        return new CouponRepositoryDatabase(databaseConnector);
    }

    @Override
    public OrderRepository createOrderRepository() {
        return new OrderRepositoryDatabase(databaseConnector);
    }
}
