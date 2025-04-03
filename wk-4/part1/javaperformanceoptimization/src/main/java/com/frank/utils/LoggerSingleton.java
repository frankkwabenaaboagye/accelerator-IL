package com.frank.utils;

import java.util.logging.Logger;

public class LoggerSingleton {

    private static final Logger logger = Logger.getLogger(LoggerSingleton.class.getName());

    private LoggerSingleton() {}

    public static Logger getLogger(){
        return logger;
    }

}
