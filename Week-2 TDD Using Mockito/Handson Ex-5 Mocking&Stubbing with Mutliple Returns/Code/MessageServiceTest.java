package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    @Test
    public void testMultipleReturns() {
        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub with multiple returns
        when(mockApi.getNextMessage())
            .thenReturn("Message 1")
            .thenReturn("Message 2")
            .thenReturn("Message 3");

        // Step 3: Inject mock and call method
        MessageService service = new MessageService(mockApi);
        String[] results = service.fetchMessages();

        // Step 4: Assert results
        assertArrayEquals(
            new String[] { "Message 1", "Message 2", "Message 3" },
            results
        );

        // ✅ Optional: Print results
        for (String msg : results) {
            System.out.println("Fetched: " + msg);
        }
    }
}
