package com.clean.architecture.application.dto;

import java.util.List;

public class SimulateFreightInput {

    private List<ItemInput> items;

    public SimulateFreightInput(List<ItemInput> items) {
        this.items = items;
    }

    public List<ItemInput> getItems() {
        return items;
    }
}
