package smallestPairWithDifferentFrequencies;

import java.util.*;

public class SmallestPairWithDifferentFrequencies {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int v : nums) {
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
        }
        List<int[]> groups = new ArrayList<>();
        for (var entry : freqMap.entrySet()) {
            groups.add(new int[] {entry.getKey(), entry.getValue()});
        }
        Collections.sort(groups, Comparator.comparingInt(p -> p[0]));
        for (int i = 0; i < groups.size(); i++) {
            for (int j = i + 1; j < groups.size(); j++) {
                if (groups.get(i)[1] != groups.get(j)[1]) {
                    return new int[] {groups.get(i)[0], groups.get(j)[0]};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
