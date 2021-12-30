package com.clean.architecture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CPFTest {
    
    @Test
    public void shouldValidadteCPFValid() throws Exception{
        new CPF("935.411.347-80");
        assertTrue(true);
    }

    @Test
    public void shouldValidateCPFInvalid(){
        try {
            new CPF("123.456.789-99");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldValidateCPFWithEqualsDigits(){
        try {
            new CPF("123.456.789-99");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldValidateCPFInvalidLong(){
        try {
            new CPF("123.456.789-99100");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldValidateCPFInvalidSmall(){
        try {
            new CPF("123.456.7");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

    @Test
    public void shouldValidateCPFInvalidNull(){
        try {
            new CPF(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "CPF Invalid");
        }
    }

}
