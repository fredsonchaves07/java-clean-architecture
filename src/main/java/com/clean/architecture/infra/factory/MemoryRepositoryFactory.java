package com.clean.architecture.infra.factory;

import com.clean.architecture.domain.factory.AbstractRepositoryFactory;
import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;
import com.clean.architecture.infra.repository.memory.CouponRepositoryMemory;
import com.clean.architecture.infra.repository.memory.ItemRepositoryMemory;
import com.clean.architecture.infra.repository.memory.OrderRepositoryMemory;

public class MemoryRepositoryFactory implements AbstractRepositoryFactory {

    @Override
    public ItemRepository createItemRepository() {
        return new ItemRepositoryMemory();
    }

    @Override
    public CouponRepository createCuponRepository() {
        return new CouponRepositoryMemory();
    }

    @Override
    public OrderRepository createOrderRepository() {
        return new OrderRepositoryMemory();
    }
}
