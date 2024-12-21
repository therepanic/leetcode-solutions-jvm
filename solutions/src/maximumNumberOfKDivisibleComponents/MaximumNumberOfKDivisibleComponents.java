package maximumNumberOfKDivisibleComponents;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfKDivisibleComponents {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] count = new int[] {1};

        dfs(0, graph, values, visited, k, count);

        return count[0];
    }

    public long dfs(int node, List<List<Integer>> graph, int[] values, boolean[] visited, int k, int[] count) {
        if (visited[node]) return 0;
        visited[node] = true;

        long sum = values[node];

        for (int curNode : graph.get(node)) {
            long curVal = dfs(curNode, graph, values, visited, k, count);

            if (curVal == -1) {
                count[0]++;
            } else {
                sum += curVal;
            }
        }

        if (sum % k == 0) {
            return -1;
        } else {
            return sum;
        }

    }
}
