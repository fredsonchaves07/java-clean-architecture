package com.clean.architecture.unit;

import com.clean.architecture.domain.entities.OrderCode;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class OrderCodeTest {

    @Test
    public void shouldCreateCodeOrder() {
        LocalDate date = LocalDate.of(2021, 3, 1);
        Integer sequence = 1;
        String code = new OrderCode(date, sequence).getCode();
        assertEquals("202100000001", code);
    }
}
