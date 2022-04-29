package com.clean.architecture.domain.factory;

import com.clean.architecture.domain.repository.CouponRepository;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.domain.repository.OrderRepository;

public interface AbstractRepositoryFactory {

    ItemRepository createItemRepository();
    CouponRepository createCuponRepository();
    OrderRepository createOrderRepository();
}
