package minimumIncrementsToEqualizeLeafPaths;

import java.util.ArrayList;
import java.util.List;

public class MinimumIncrementsToEqualizeLeafPaths {
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] inc = new int[n];
        dfs(0, -1, graph, cost, inc);
        return inc[0];
    }

    private long dfs(int node, int parent, List<List<Integer>> graph, int[] cost, int[] inc) {
        long maxChildSum = Long.MIN_VALUE;
        int children = 0;
        List<Long> childSums = new ArrayList<>();
        for (int v : graph.get(node)) {
            if (v == parent) {
                continue;
            }
            children++;
            long sum = dfs(v, node, graph, cost, inc);
            childSums.add(sum);
            maxChildSum = Math.max(maxChildSum, sum);
        }
        if (children == 0) {
            return cost[node];
        }
        for (long sum : childSums) {
            if (sum < maxChildSum) {
                inc[0]++;
            }
        }
        return maxChildSum + cost[node];
    }


}
