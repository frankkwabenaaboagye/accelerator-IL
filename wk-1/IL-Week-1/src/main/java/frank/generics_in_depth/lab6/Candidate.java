package frank.generics_in_depth.lab6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Candidate {

    private String name;
    private int age;
    private String party;
    private int votesReceived;


    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", party='" + party + '\'' +
                ", votesReceived=" + votesReceived +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return age == candidate.age &&
                votesReceived == candidate.votesReceived &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(party, candidate.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, party, votesReceived);
    }
}
