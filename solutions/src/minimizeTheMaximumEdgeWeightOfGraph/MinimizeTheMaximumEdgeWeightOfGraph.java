package minimizeTheMaximumEdgeWeightOfGraph;

import java.util.ArrayList;
import java.util.List;

public class MinimizeTheMaximumEdgeWeightOfGraph {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int l = 0;
        int r = 0;
        for (int[] edge : edges) {
            r = Math.max(edge[2], r);
        }
        int answer = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ok(n, edges, mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    public boolean ok(int n, int[][] edges, int weight) {
        List<List<Integer>> reversed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reversed.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (edge[2] <= weight) {
                reversed.get(edge[1]).add(edge[0]);
            }
        }

        boolean[] visited = new boolean[n];
        bypass(0, reversed, visited);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void bypass(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                bypass(neighbor, graph, visited);
            }
        }
    }
}
