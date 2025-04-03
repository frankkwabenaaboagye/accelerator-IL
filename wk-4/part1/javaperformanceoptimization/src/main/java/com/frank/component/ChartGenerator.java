package com.frank.component;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.frank.utils.LoggerSingleton;

public class ChartGenerator {
    private static final int maxSize = 5;

    public void generateChart(Map<String, Integer> artistPlayCounts){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        artistPlayCounts.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(maxSize)
            .forEach(entry -> dataset.addValue(entry.getValue(), "Plays", entry.getKey()));

        JFreeChart barChart = ChartFactory.createBarChart(
            "Top 5 Streamed Artists", 
            "Artists", 
            "PlayCount", 
            dataset,
            PlotOrientation.VERTICAL,
            false, true, false);

            int width = 800;
            int height = 600;

            File charFile =  new File("top_artists_chart.png");
            try {
                ChartUtils.saveChartAsPNG(charFile, barChart, width, height);
                
            } catch (IOException e) {

                LoggerSingleton
                    .getLogger()
                    .log(Level.SEVERE, ()-> String.format("Error Saving chart: %s", e.getMessage()));

            }
        

    }

}
