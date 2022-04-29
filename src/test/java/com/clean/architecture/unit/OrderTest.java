package com.clean.architecture.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import com.clean.architecture.domain.entities.Coupon;
import com.clean.architecture.domain.entities.Item;
import com.clean.architecture.domain.entities.Order;
import org.junit.Test;

public class OrderTest {
    Order order;
    
    @Test
    public void shouldNotCreateOrderWithCPFInvalid() {
        try {
            order = new Order("111.111.111-11");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldCreateOrder() throws Exception {
        order = new Order("298.585.540-36");
        assertTrue(true);
    }

    @Test
    public void shouldCreateOrderWith3Items() throws Exception {
        order = new Order("298.585.540-36");
        order.addItem(new Item("1", "Instrumentos Musicais", "Guitarra", 1000), 1);
        order.addItem(new Item("2", "Instrumentos Musicais", "Amplificador", 5000), 1);
        order.addItem(new Item("3", "Instrumentos Musicais", "Guitarra", 30), 3);
        assertEquals(6090, order.getTotal(), 0);
    }

    @Test
    public void shouldCreateOrderWith3ItemsWithDescountCoupon() throws Exception {
        order = new Order("298.585.540-36");
        order.addItem(new Item("1", "Instrumentos Musicais", "Guitarra", 1000), 1);
        order.addItem(new Item("2", "Instrumentos Musicais", "Amplificador", 5000), 1);
        order.addItem(new Item("3", "Instrumentos Musicais", "Guitarra", 30), 3);
        order.addCoupon(new Coupon("VALE20", 20));
        assertEquals(4872, order.getTotal(), 0);
    }

    @Test
    public void shouldCreateOrderWith3ItemsWithInvalidCoupon() throws Exception {
        order = new Order("298.585.540-36", LocalDate.of(2022, 01, 15));
        order.addItem(new Item("1", "Instrumentos Musicais", "Guitarra", 1000), 1);
        order.addItem(new Item("2", "Instrumentos Musicais", "Amplificador", 5000), 1);
        order.addItem(new Item("3", "Instrumentos Musicais", "Guitarra", 30), 3);
        order.addCoupon(new Coupon("VALE20", 20, LocalDate.of(2022, 01, 01)));
        assertEquals(6090, order.getTotal(), 0);
    }

    @Test
    public void shouldCreateOrderWithOrderCode() throws Exception {
        order = new Order("298.585.540-36", LocalDate.of(2021, 3, 1));
        order.addItem(new Item("1", "Instrumentos Musicais", "Guitarra", 1000, 100, 30, 10, 3), 1);
        order.addItem(new Item("2", "Instrumentos Musicais", "Amplificador", 5000, 100, 50, 50, 20), 1);
        order.addItem(new Item("3", "Instrumentos Musicais", "Guitarra", 30, 10, 10, 10, 0.9), 3);
        assertEquals("202100000001", order.getCode());
    }
}
