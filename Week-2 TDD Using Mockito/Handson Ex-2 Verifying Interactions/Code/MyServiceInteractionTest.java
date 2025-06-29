package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class MyServiceInteractionTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject the mock into the service
        MyService service = new MyService(mockApi);

        // Step 3: Call the method (Act)
        String data = service.fetchData();

        // Step 4: Verify interaction
        verify(mockApi).getData();

        // ✅ Output to console
        System.out.println("fetchData() was called, and getData() interaction verified.");
    }
}
