package com.frank.component;

import java.util.*;
import java.util.logging.Logger;

import com.frank.utils.LoggerSingleton;
import com.google.gson.Gson;

public class DataProcessor {

    public void randomProcess(List<String[]> records){
        Logger logger = LoggerSingleton.getLogger();
        int counter  = 0;

        Gson gson = new Gson();

        for(String[] rec: records){
            
            if (counter > 50) {
                break;
            }
            
            Map<String, String> recordMap = new LinkedHashMap<>();

            recordMap.put("Record", String.valueOf(counter));
            recordMap.put("spotify_track_uri", rec[0]);
            recordMap.put("ts", rec[1]);
            recordMap.put("platform", rec[2]);
            recordMap.put("ms_played", rec[3]);
            recordMap.put("track_name", rec[4]);
            recordMap.put("artist_name", rec[5]);
            recordMap.put("album_name", rec[6]);
            recordMap.put("reason_start", rec[7]);
            recordMap.put("reason_end", rec[8]);
            recordMap.put("shuffle", rec[9]);
            recordMap.put("skipped", rec[10]);

            String theJson = gson.toJson(recordMap);

            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                
                logger.info(theJson);
            }
            // System.out.println(" \n");   

            counter ++;
        
        }
    }

    // second one
//    public Map<String, Integer> process(List<String[]> records) {
//        Map<String, Integer> artistPlayCount = new HashMap<>();
//        for (String[] rec: records) {
//            if (rec.length < 2) continue;
//            String artistName = rec[5];
//            artistPlayCount.put(artistName, artistPlayCount.getOrDefault(artistName, 0) + 1);
//
//        }
//        return artistPlayCount;
//
//    }

    // first one
    public Map<String, Integer> process(List<String[]> records) {
        Map<String, Integer> artistPlayCount = new HashMap<>();

        for (String[] rec : records) {
            if (rec.length < 6) { // Ensure at least 6 columns before accessing index 5
                LoggerSingleton.getLogger().warning("Skipping invalid row: " + Arrays.toString(rec));
                continue;
            }

            String artistName = rec[5];
            artistPlayCount.merge(artistName, 1, Integer::sum);
        }

        return artistPlayCount;
    }

}
