# Java Application to process and Analyse Spotify Streaming History
- link to data 
    - [https://mavenanalytics.io/data-playground](https://mavenanalytics.io/data-playground)
- Things to note about the simple application
     - `CSVReader` → Reads data from the CSV file
     - `DataProcessor` → Analyzes streaming data
     - `ChartGenerator` → Creates and saves a bar chart
     - `SpotifyDataProcessor` → Main controller that orchestrates the process

    - output of the analysis
        - ![](./javaperformanceoptimization/top_artists_chart.png)

- Using a profiling tool
    - some of the profiling tools out there
        - VisualVM 
        - JProfiler
        - YourKit
        - JConsole
        - ...
