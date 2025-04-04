package com.frank.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import com.frank.utils.LoggerSingleton;

public class CSVReader {

    public List<String[]> readCSV(String filePath){
        List<String[]> records = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(Paths.get(filePath))){
            String line;
            while((line = br.readLine()) != null){
                records.add(line.split(","));
            }
        }catch(IOException e){
            LoggerSingleton
                .getLogger()
                .log(Level.SEVERE, () -> String.format("Error reading the CSV file: %s", e.getMessage()));
        }

        return records;
    }

//    public List<String[]> readCSV(String filePath) {
//        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
//            return br.lines()
//                    .map(line -> line.split(",", -1)) // Handle missing values properly
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            LoggerSingleton.getLogger().log(Level.SEVERE,
//                    () -> String.format("Error reading the CSV file: %s", e.getMessage()));
//            return Collections.emptyList(); // Return empty list instead of null
//        }
//    }

}
