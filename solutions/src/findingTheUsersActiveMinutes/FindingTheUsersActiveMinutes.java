package findingTheUsersActiveMinutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> countMap = new HashMap<>();
        for (int[] log : logs) {
            countMap.computeIfAbsent(log[0], p -> new HashSet<>()).add(log[1]);
        }
        int[] ans = new int[k];
        for (var entry : countMap.entrySet()) {
            ans[entry.getValue().size()]++;
        }
        return ans;
    }
}
