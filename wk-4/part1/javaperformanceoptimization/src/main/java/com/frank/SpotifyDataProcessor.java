package com.frank;

import java.util.List;
import java.util.Map;

import com.frank.component.CSVReader;
import com.frank.component.ChartGenerator;
import com.frank.component.DataProcessor;

public class SpotifyDataProcessor {
    private static final String FILE_PATH = "src/main/resources/spotify_history.csv";

    public void processSpotifyData(){
        CSVReader csvReader = new CSVReader();
        List<String[]> records = csvReader.readCSV(FILE_PATH);

        DataProcessor dataProcessor = new DataProcessor();
        Map<String, Integer> artistPlayCount = dataProcessor.process(records);

        ChartGenerator chartGenerator = new ChartGenerator();  
        chartGenerator.generateChart(artistPlayCount);
    
    }

}
