package com.clean.architecture.integration;


import com.clean.architecture.application.dto.ItemInput;
import com.clean.architecture.application.dto.SimulateFreightInput;
import com.clean.architecture.application.usecase.SimulateFreight;
import com.clean.architecture.domain.repository.ItemRepository;
import com.clean.architecture.infra.database.DatabaseConnectionAdapter;
import com.clean.architecture.infra.database.DatabaseConnector;
import com.clean.architecture.infra.repository.database.ItemRepositoryDatabase;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SimulateFreightTest {

    DatabaseConnector databaseConnector = new DatabaseConnectionAdapter();
    ItemRepository itemRepository = new ItemRepositoryDatabase(databaseConnector);
    List<ItemInput> items = new ArrayList<>();

    public SimulateFreightTest() throws SQLException {
    }

    @Test
    public void shouldSimulateFreight() throws SQLException {
        items.add(new ItemInput("1", 1));
        items.add(new ItemInput("2", 1));
        items.add(new ItemInput("3", 3));
        SimulateFreight simulateFreight = new SimulateFreight(itemRepository);
        assertEquals(280.0, simulateFreight.execute(new SimulateFreightInput(items)), 0);
    }
}
