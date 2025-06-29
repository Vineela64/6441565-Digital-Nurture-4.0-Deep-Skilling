package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "vineela123";
        String action = "uploaded a file";
        LocalDateTime loginTime = LocalDateTime.now();

        // Parameterized logging
        logger.info("User {} performed action: {}", username, action);
        logger.debug("User {} logged in at {}", username, loginTime);

        // Additional example
        int itemCount = 5;
        logger.warn("Cart contains {} items but checkout not completed", itemCount);

        System.out.println("Parameterized logging complete. Check console output.");
    }
}
