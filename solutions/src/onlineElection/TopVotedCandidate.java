package onlineElection;

import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {

    private final TreeMap<Integer, Integer> timePersonMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.timePersonMap = new TreeMap<>();
        int[] personsVote = new int[persons.length];
        int max = -1;
        int maxPerson = -1;
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            int person = persons[i];
            personsVote[person]++;
            if (max <= personsVote[person]) {
                max = personsVote[person];
                maxPerson = person;
            }
            timePersonMap.put(time, maxPerson);
        }
    }

    public int q(int t) {
        Map.Entry<Integer, Integer> val = timePersonMap.floorEntry(t);
        return val == null ? -1 : val.getValue();
    }
}
