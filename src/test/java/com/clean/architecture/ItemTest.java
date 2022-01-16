package com.clean.architecture;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
    
    @Test
    public void shouldCreateItem() {
        Item item = new Item("1", "Instrumentos Musicais", "Guitarra", 1000);
        assertEquals("1", item.getIdItem());
    }

    @Test
    public void shouldCreateItemAndCalcVolume() {
        Item item = new Item("1", "Instrumentos Musicais", "Guitarra", 1000, 100, 30, 10);
        assertEquals(0.03, item.getVolume(), 0);
    }

    @Test
    public void shouldCreateItemAndCalcDensity() {
        Item item = new Item("1", "Instrumentos Musicais", "Guitarra", 1000, 100, 30, 10, 3);
        assertEquals(100, item.getDensity(), 0);
    }

    @Test
    public void shouldCreateItemAndCalcFreight() {
        Item item = new Item("1", "Instrumentos Musicais", "Guitarra", 1000, 100, 30, 10, 3);
        assertEquals(30, item.getFreight(), 0);
    }

    @Test
    public void shouldCreateItemAndCalcFreightMinimun() {
        Item item = new Item("2", "Instrumentos Musicais", "Cabo", 30, 10, 10, 10, 0.9);
        assertEquals(10, item.getFreight(), 0);
    }
}
