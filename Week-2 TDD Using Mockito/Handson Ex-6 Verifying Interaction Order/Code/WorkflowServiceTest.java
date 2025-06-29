package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;

public class WorkflowServiceTest {

    @Test
    public void testMethodCallOrder() {
        // Step 1: Create mock
        TaskManager mockManager = mock(TaskManager.class);

        // Step 2: Inject mock and run
        WorkflowService service = new WorkflowService(mockManager);
        service.runWorkflow();

        // Step 3: Verify call order
        InOrder inOrder = inOrder(mockManager);

        inOrder.verify(mockManager).start();
        inOrder.verify(mockManager).execute();
        inOrder.verify(mockManager).finish();

        // ✅ Console output
        System.out.println("Method call order verified successfully.");
    }
}
