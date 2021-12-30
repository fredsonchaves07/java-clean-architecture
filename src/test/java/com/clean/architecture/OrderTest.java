package com.clean.architecture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderTest {
    Order order;
    
    @Test
    public void shouldNotCreateOrderWithCPFInvalid(){
        try {
            order = new Order("111.111.111-11");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldCreateOrder() throws Exception{
        order = new Order("298.585.540-36");
        assertTrue(true);
    }

    @Test
    public void shouldCreateOrderWith3Items() throws Exception{
        order = new Order("298.585.540-36");
        order.addItem(new Item("1", "Instrumentos Musicais", "Guitarra", 1000), 1);
        order.addItem(new Item("2", "Instrumentos Musicais", "Amplificador", 5000), 1);
        order.addItem(new Item("3", "Instrumentos Musicais", "Guitarra", 30), 3);
        assertEquals(6090, order.getTotal(), 0);
    }
}
