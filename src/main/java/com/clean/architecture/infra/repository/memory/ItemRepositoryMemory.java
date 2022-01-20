package com.clean.architecture.infra.repository.memory;

import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemRepositoryMemory implements ItemRepository {

    List<Item> items = new ArrayList<>();

    public ItemRepositoryMemory(){
        this.items.add(new Item("1", "Instrumentos Musicais", "Guitarra", 1000));
        this.items.add(new Item("2", "Instrumentos Musicais", "Amplificador", 5000));
        this.items.add(new Item("3", "Instrumentos Musicais", "Cabo", 30));
    }

    @Override
    public Item findById(String idItem) {
        Item item = this.items.stream().filter(itemList -> Objects.equals(itemList.getIdItem(), idItem)).findAny().orElse(null);
        if (item == null) throw new RuntimeException("Item not found");
        return item;
    }
}
