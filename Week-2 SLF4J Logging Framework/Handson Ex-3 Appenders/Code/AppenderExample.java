package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {

        logger.debug("Debug level message");
        logger.info("Info level message");
        logger.warn("Warning level message");
        logger.error("Error level message");

        System.out.println("Logging completed. Check console and 'app.log' file.");
    }
}
