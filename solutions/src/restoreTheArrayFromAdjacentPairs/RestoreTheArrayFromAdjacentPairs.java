package restoreTheArrayFromAdjacentPairs;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> all = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            all.computeIfAbsent(pair[1], p -> new ArrayList<>()).add(pair[0]);
            all.computeIfAbsent(pair[0], p -> new ArrayList<>()).add(pair[1]);
        }
        int[] answer = new int[adjacentPairs.length + 1];
        for (var entry : all.entrySet()) {
            if (entry.getValue().size() == 1) {
                dfs(entry.getKey(), answer, new int[1], all, new HashSet<>());
                break;
            }
        }
        return answer;
    }

    private void dfs(int cur, int[] answer, int[] index, Map<Integer, List<Integer>> all, Set<Integer> checked) {
        answer[index[0]] = cur;
        index[0]++;
        checked.add(cur);
        for (int node : all.get(cur)) {
            if (!checked.contains(node)) {
                dfs(node, answer, index, all, checked);
            }
        }
    }
}
