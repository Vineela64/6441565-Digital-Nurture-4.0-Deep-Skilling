package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils utils = new MathUtils();
        int result = utils.add(10, 5);
        System.out.println("Result is: " + result); 
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        MathUtils utils = new MathUtils();
        int result = utils.subtract(10, 5);
        System.out.println("Subtraction result is: " + result);
        assertEquals(5, result);
    }

    @Test
    public void testIsEvenTrue() {
        MathUtils utils = new MathUtils();
        assertTrue(utils.isEven(8));
    }

    @Test
    public void testIsEvenFalse() {
        MathUtils utils = new MathUtils();
        assertFalse(utils.isEven(7));
    }
}
