package maximizeScoreAfterZeroingSubtrees;

import java.util.ArrayList;
import java.util.List;

public class MaximizeScoreAfterZeroingSubtrees {
    public int maxScore(int[] parent, int[] op, int[] score) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            graph.get(parent[i]).add(i);
        }
        return bypass(0, graph, op, score);
    }

    public int bypass(int node, List<List<Integer>> graph, int[] op, int[] score) {
        if (graph.get(node).isEmpty()) {
            return score[node];
        }
        int sum = score[node];
        int min = Integer.MAX_VALUE;
        for (int v : graph.get(node)) {
            int a = bypass(v, graph, op, score);
            sum += a;
            min = Math.min(min, a);
        }
        if (op[node] == 1) {
            return sum - min;
        } else {
            if (min < 0) {
                sum -= min;
            }
            return sum;
        }
    }

}
