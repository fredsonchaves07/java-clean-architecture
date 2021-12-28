package com.clean.architecture;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CPFTest {
    
    @Test
    public void shouldValidadteCPFValid(){
        CPFValidator cpfValidator = new CPFValidator("935.411.347-80");
        boolean isValid = cpfValidator.validate();

        assertTrue(isValid);
    }

    @Test
    public void shouldValidateCPFInvalid(){
        CPFValidator cpfValidator = new CPFValidator("123.456.789-99");
        boolean isValid = cpfValidator.validate();

        assertFalse(isValid);
    }

    @Test
    public void shouldValidateCPFWithEqualsDigits(){
        CPFValidator cpfValidator = new CPFValidator("111.111.111-11");
        boolean isValid = cpfValidator.validate();

        assertFalse(isValid);
    }

    @Test
    public void shouldValidateCPFInvalidLong(){
        CPFValidator cpfValidator = new CPFValidator("123.456.789-99100");
        boolean isValid = cpfValidator.validate();

        assertFalse(isValid);
    }

    @Test
    public void shouldValidateCPFInvalidSmall(){
        CPFValidator cpfValidator = new CPFValidator("123.456.7");
        boolean isValid = cpfValidator.validate();

        assertFalse(isValid);
    }

    @Test
    public void shouldValidateCPFInvalidNull(){
        CPFValidator cpfValidator = new CPFValidator(null);
        boolean isValid = cpfValidator.validate();

        assertFalse(isValid);
    }

}
