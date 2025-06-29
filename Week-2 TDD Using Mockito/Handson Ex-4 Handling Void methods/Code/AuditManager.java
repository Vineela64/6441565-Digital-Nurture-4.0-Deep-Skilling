package com.example;

public class AuditManager {
    private LoggerService logger;

    public AuditManager(LoggerService logger) {
        this.logger = logger;
    }

    public void recordAction(String action) {
        logger.log("Action recorded: " + action);
    }
}
