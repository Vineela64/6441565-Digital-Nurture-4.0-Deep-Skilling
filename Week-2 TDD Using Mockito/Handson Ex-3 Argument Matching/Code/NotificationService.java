package com.example;

public class NotificationService {
	private UserNotifier notifier;

    public NotificationService(UserNotifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String userId) {
        String message = "Hello " + userId + ", you have a new message!";
        notifier.sendNotification(userId, message);
    }

}
