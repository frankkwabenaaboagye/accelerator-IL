package frank.generics_in_depth.lab6;

import java.util.*;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;

public class GhanaElection {
    public static void main(String[] args) {
        // Sample data: List of Candidates
        List<Candidate> candidates = Arrays.asList(
                new Candidate("Kwame Nkrumah", 55, "CPP", 500000),
                new Candidate("John Dramani Mahama", 66, "NDC", 40000),
                new Candidate("Nana Akufo-Addo", 80, "NPP", 1000),
                new Candidate("Frank Aboagye", 22, "Independent", 10000000)
        );

        // I am sorting using the custom comparator I wrote
        List<Candidate> sortedCandidates = candidates.stream()
                .sorted(new CandidateComparator()) // Sort by custom comparator
                .toList();

        // for filtering I will filter by age >= 55
        List<Candidate> filteredCandidates = sortedCandidates.stream()
                .filter(candidate -> candidate.getAge() >= 55)  // Filter by age
                .toList();

        // this will act as the transforming
        List<String> transformedCandidates = filteredCandidates.stream()
                .map(candidate -> String.format("Name: %s, Party: %s, Votes: %d",
                        candidate.getName(), candidate.getParty(), candidate.getVotesReceived()))
                .toList();

        // i wrote this for the processing
        int totalVotes = filteredCandidates.stream()
                .mapToInt(Candidate::getVotesReceived)
                .sum();

        System.out.println("Filtered and Transformed Candidate Information:");
        transformedCandidates.forEach(System.out::println);

        System.out.println("\nTotal Votes from filtered candidates: " + totalVotes);
    }
}

