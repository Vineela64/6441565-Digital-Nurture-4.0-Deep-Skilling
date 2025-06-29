package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class AuditManagerTest {

    @Test
    public void testVoidMethodLogging() {
        // Step 1: Create a mock
        LoggerService mockLogger = mock(LoggerService.class);

        // Step 2: Stub the void method (optional here, but possible)
        // doNothing().when(mockLogger).log(anyString());  // not needed unless exception or doThrow

        // Step 3: Use the mock
        AuditManager manager = new AuditManager(mockLogger);
        manager.recordAction("DELETE_USER");

        // Step 4: Verify interaction
        verify(mockLogger).log("Action recorded: DELETE_USER");

        // ✅ Optional console output
        System.out.println("Void method log() verified successfully.");
    }
}
