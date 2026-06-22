package maximumPathQualityOfAGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumPathQualityOfAGraph {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> graph = new ArrayList<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
            graph.get(edges[i][1]).add(new int[] {edges[i][0], edges[i][2]});
        }
        int[] ans = new int[1];
        helper(0, 0, values, 0, maxTime, graph, ans, new HashSet<>());
        return ans[0];
    }

    public void helper(int node, int sum, int[] values, int time, int maxTime, List<List<int[]>> graph, int[] ans, Set<Integer> already) {
        if (time > maxTime) {
            return;
        }
        boolean isNew = already.add(node);
        if (isNew) {
            sum += values[node];
        }
        if (node == 0) {
            ans[0] = Math.max(ans[0], sum);
        }
        for (int[] v : graph.get(node)) {
            helper(v[0], sum, values, time + v[1], maxTime, graph, ans, already);
        }
        if (isNew) {
            already.remove(node);
        }
    }
}
