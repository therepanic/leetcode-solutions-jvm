package maximumScoreAfterApplyingOperationsOnATree;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreAfterApplyingOperationsOnATree {

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        long total = 0;
        for (int v : values) {
            total += v;
        }
        return total - bypass(graph, 0, values, -1);
    }

    public long bypass(List<List<Integer>> graph, int node, int[] values, int prev) {
        boolean isLeaf = true;
        long sum = 0;
        for (int v : graph.get(node)) {
            if (v == prev) continue;
            isLeaf = false;
            sum += bypass(graph, v, values, node);
        }
        if (isLeaf) {
            return values[node];
        }
        return Math.min(values[node], sum);
    }

}
