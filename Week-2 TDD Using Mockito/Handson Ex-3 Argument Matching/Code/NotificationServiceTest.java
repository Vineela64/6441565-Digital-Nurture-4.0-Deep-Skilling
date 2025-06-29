package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class NotificationServiceTest {

    @Test
    public void testSendNotificationWithCorrectArguments() {
  
        UserNotifier mockNotifier = mock(UserNotifier.class);
        NotificationService service = new NotificationService(mockNotifier);

        service.notifyUser("vineela123");

        verify(mockNotifier).sendNotification(eq("vineela123"), contains("Hello"));

        System.out.println("sendNotification() was called with expected arguments.");
    }
}
