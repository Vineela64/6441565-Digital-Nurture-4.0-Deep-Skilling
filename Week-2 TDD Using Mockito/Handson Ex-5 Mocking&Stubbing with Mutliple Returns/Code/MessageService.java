package com.example;

public class MessageService {
	private ExternalApi api;

    public MessageService(ExternalApi api) {
        this.api = api;
    }

    public String[] fetchMessages() {
        return new String[] {
            api.getNextMessage(),
            api.getNextMessage(),
            api.getNextMessage()
        };
    }

}
