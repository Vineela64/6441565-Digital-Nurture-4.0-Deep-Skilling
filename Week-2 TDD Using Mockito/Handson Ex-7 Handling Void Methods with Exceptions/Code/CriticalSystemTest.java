package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CriticalSystemTest {

    public void testSendAlertThrowsException() {
        AlertService mockAlert = mock(AlertService.class);

        doThrow(new RuntimeException("Alert service failed"))
            .when(mockAlert).sendAlert("CRITICAL: System failure!");

        CriticalSystem system = new CriticalSystem(mockAlert);

        try {
            system.performCriticalOperation();
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            assertEquals("Alert service failed", ex.getMessage());
            System.out.println("Exception caught and verified successfully.");
        }
        verify(mockAlert).sendAlert("CRITICAL: System failure!");
    }
}

