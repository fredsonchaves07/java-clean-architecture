package com.clean.architecture;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CPFValidator cpfValidator = new CPFValidator("935.411.347-80");
        cpfValidator.validate();

    }
}
