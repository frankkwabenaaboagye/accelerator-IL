package frank.exceptionhandlinginjava.ex1_checkandunchecked;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This program processes Ghana's election results using a CSV file.
 * It demonstrates handling both checked and unchecked exceptions while declaring "Frank Aboagye" as the winner.
 *
 * The CSV file should contain the following data:
 * candidate,votes
 * Frank Aboagye,102345
 * John Mahama,98765
 * Nana Ado,54321
 *
 * Methods:
 * 1. readElectionResults - Reads the election results from a CSV file (throws a checked exception).
 * 2. findWinner - Determines the winner from the parsed election results (throws an unchecked exception if data is invalid).
 *
 * Exception Handling:
 * - Demonstrates handling of checked exceptions for file operations.
 * - Demonstrates handling of unchecked exceptions for invalid data.
 */
public class GhanaElectionProcessor {

    /**
     * Reads the election results from a CSV file.
     * @param filePath The path to the CSV file.
     * @return A map of candidates and their vote counts.
     * @throws IOException If the file cannot be read.
     */
    public static Map<String, Integer> readElectionResults(String filePath) throws IOException {
        Map<String, Integer> results = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;
            while((line = br.readLine()) != null){
                if (isFirstLine) { // Skip the header line
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if(parts.length != 2) throw new IllegalArgumentException("There is a problem with the csv on this line: " + line);
                String candidate = parts[0].trim();
                int votes;
                try{
                    votes = Integer.parseInt(parts[1].trim());
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid vote count for candidate " + candidate + ": " + parts[1]);
                }
                results.put(candidate, votes);
            }
        }
        return results;
    }

    /**
     * Determines the winner of the election based on the results.
     * @param results A map of candidates and their vote counts.
     * @return The name of the winning candidate.
     * @throws IllegalArgumentException If the results are empty or invalid.
     */
    public static String findWinner(Map<String, Integer> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("No election results provided.");
        }
        return results.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("No winner found in the results."))
                .getKey();
    }


    public static void main(String[] args) {
        try {
            Map<String, Integer> results = readElectionResults("election_results.csv");
            String winner = findWinner(results);
            System.out.println("The winner of the 2024 Ghana election is: " + winner);
        } catch (IOException e) {
            System.out.println("Error reading the election results file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid election data: " + e.getMessage());
        } finally {
            System.out.println("Election processing completed.");
        }

    }
}
