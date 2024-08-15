package minimumScoreOfAPathBetweenTwoCities;

import java.util.*;

public class MinimumScoreOfAPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            road[0]--;
            road[1]--;
            graph.get(road[0]).add(new int[] {road[1], road[2]});
            graph.get(road[1]).add(new int[] {road[0], road[2]});
        }

        Set<Integer> visited = new HashSet<>();
        int[] minScore = new int[] {Integer.MAX_VALUE};

        helper(0, graph, visited, minScore);

        return minScore[0];
    }

    public void helper(int currentValue, List<List<int[]>> graph, Set<Integer> visited, int[] minScore) {
        visited.add(currentValue);

        for (int[] value : graph.get(currentValue)) {
            if (!visited.contains(value[0]) || value[1] < minScore[0]) {
                minScore[0] = Math.min(minScore[0], value[1]);

                helper(value[0], graph, visited, minScore);
            }
        }
    }
}
