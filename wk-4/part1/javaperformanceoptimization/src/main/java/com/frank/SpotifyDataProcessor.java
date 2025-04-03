package com.frank;

import java.util.List;

import com.frank.component.CSVReader;
import com.frank.component.DataProcessor;

public class SpotifyDataProcessor {
    private static final String FILE_PATH = "src/main/resources/spotify_history.csv";

    public void processSpotifyData(){
        CSVReader csvReader = new CSVReader();
        List<String[]> records = csvReader.readCSV(FILE_PATH);

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.process(records);
    }

}
