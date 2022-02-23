package com.clean.architecture.application.usecase;

import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.SimulateFreightInput;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.ItemRepository;

import java.sql.SQLException;
import java.util.List;

public class SimulateFreight {

    private ItemRepository itemRepository;

    public SimulateFreight(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Double execute(SimulateFreightInput input) throws SQLException {
        double freight = 0;
        for (ItemInput itemInput : input.getItems()) {
            Item item = itemRepository.findById(itemInput.getIdItem());
            freight += item.getFreight() * itemInput.getQuantity();
        }
        return freight;
    }
}
