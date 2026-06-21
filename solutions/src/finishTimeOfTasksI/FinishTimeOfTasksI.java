package finishTimeOfTasksI;

import java.util.ArrayList;
import java.util.List;

public class FinishTimeOfTasksI {

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        return helper(0, graph, baseTime);
    }

    public long helper(int node, List<List<Integer>> graph, int[] baseTime) {
        if (graph.get(node).isEmpty()) {
            return baseTime[node];
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int v : graph.get(node)) {
            long a = helper(v, graph, baseTime);
            min = Math.min(a, min);
            max = Math.max(a, max);
        }
        return max + max - min + baseTime[node];
    }
}
