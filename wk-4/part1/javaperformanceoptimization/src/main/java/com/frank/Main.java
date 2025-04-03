package com.frank;
import java.util.logging.Logger;

import com.frank.utils.LoggerSingleton;

public class Main {
    public static void main(String[] args) {
        SpotifyDataProcessor spotifyDataProcessor = new SpotifyDataProcessor();
    
        Logger logger = LoggerSingleton.getLogger();
        logger.info("running the data processng app!");

        spotifyDataProcessor.processSpotifyData();

        logger.info("finished the data processing app!");
        
    }
}