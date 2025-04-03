package com.frank;
import java.util.logging.Logger;

import com.frank.utils.LoggerSingleton;

public class Main {
    public static void main(String[] args) {
        SpotifyDataProcessor spotifyDataProcessor = new SpotifyDataProcessor();
    
        Logger logger = LoggerSingleton.getLogger();
        logger.info("running the data processng app!");
        
        long startTime = System.nanoTime();

        spotifyDataProcessor.processSpotifyData();

        long  endTime = System.nanoTime();
        if (logger.isLoggable(java.util.logging.Level.INFO)) { // just conditionally log
            logger.info(String.format("Time taken to process the data: %d ms", (endTime - startTime) / 1_000_000));
        }
        logger.info("finished the data processing app!");
        
    }
}