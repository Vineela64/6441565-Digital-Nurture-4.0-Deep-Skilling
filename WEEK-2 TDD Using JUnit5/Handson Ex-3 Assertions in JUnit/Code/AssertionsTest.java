package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
    	assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        String nullString = null;
        assertNull(nullString);

        String notNullString = "Hello";
        assertNotNull(notNullString);
        System.out.println("All assertions ran successfully.");

    }
}
