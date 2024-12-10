package frank.generics_in_depth.lab6;

import java.util.Comparator;

public class CandidateComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate c1, Candidate c2) {
        int voteComparison = Integer.compare(c2.getVotesReceived(), c1.getVotesReceived()); // compare by votes received (descending) - firstly

        // If votes are the same, compare by age (ascending)
        if (voteComparison == 0) {
            return Integer.compare(c1.getAge(), c2.getAge());
        }
        return voteComparison;
    }
}
