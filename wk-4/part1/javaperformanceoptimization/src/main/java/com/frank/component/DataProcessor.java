package com.frank.component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.frank.utils.LoggerSingleton;

public class DataProcessor {

    public void process(List<String[]> records){
        Logger logger = LoggerSingleton.getLogger();
        int counter  = 0;

        for(String[] rec: records){
            
            if (counter > 50) {
                break;
            }
            
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(Arrays.toString(rec));
            }

            counter ++;
        
        }
    }

}
