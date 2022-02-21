package com.clean.architecture.domain.repository;

import com.clean.architecture.domain.entities.Item;

import java.sql.SQLException;

public interface ItemRepository {

    Item findById(String idItem) throws SQLException;
}
