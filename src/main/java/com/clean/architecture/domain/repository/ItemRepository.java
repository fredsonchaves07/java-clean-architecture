package com.clean.architecture.domain.repository;

import com.clean.architecture.domain.entities.Item;

public interface ItemRepository {

    Item findById(String idItem);
}
