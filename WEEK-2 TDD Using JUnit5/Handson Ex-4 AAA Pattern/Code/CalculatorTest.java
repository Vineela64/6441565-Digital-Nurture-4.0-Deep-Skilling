package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;  // shared object

    // Setup method – runs before every test
    @Before
    public void setUp() {
        System.out.println("Setup: Creating Calculator object");
        calculator = new Calculator();  // Arrange
    }

    // Teardown method – runs after every test
    @After
    public void tearDown() {
        System.out.println("Teardown: Cleaning up");
        calculator = null;  // cleanup
    }

    @Test
    public void testMultiply() {
        // Act
        int result = calculator.multiply(4, 5);
        
        // Assert
        assertEquals(20, result);
    }

    @Test
    public void testIsPositive() {
        // Act
        boolean result = calculator.isPositive(7);

        // Assert
        assertTrue(result);
    }
}

