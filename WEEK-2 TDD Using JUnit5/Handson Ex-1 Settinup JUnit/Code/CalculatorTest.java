package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 5);
        System.out.println("Addition result: " + result); 
        assertEquals(15, result);
    }
}
