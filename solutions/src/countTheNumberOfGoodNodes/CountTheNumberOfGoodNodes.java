package countTheNumberOfGoodNodes;

import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfGoodNodes {
    public int countGoodNodes(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] sum = new int[1];
        dfs(0, graph, sum, new boolean[edges.length + 1]);
        return sum[0];
    }

    private int dfs(int cur, List<List<Integer>> graph, int[] sum, boolean[] visited) {
        int size = 0;
        int s = 0;
        boolean ok = true;
        visited[cur] = true;
        for (int node : graph.get(cur)) {
            if (visited[node]) continue;
            if (size == 0) {
                size = dfs(node, graph, sum, visited);
                s = size;
            } else {
                int temp = dfs(node, graph, sum, visited);
                s += temp;
                if (temp != size) {
                    ok = false;
                }
            }
        }
        if (ok) {
            sum[0]++;
        }

        return s + 1;
    }
}
