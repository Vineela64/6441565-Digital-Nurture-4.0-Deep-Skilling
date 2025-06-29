package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Step 4: Assert the result
        assertEquals("Mock Data", result);

        // (Optional) Verify interaction
        verify(mockApi).getData();
        System.out.println("Result: " + result);    }
}
