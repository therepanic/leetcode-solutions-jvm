package minimumEdgeTogglesOnATree;

import java.util.*;

public class MinimumEdgeTogglesOnATree {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        char[] starts = start.toCharArray();
        char[] targets = target.toCharArray();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }
        List<Integer> indexes = new ArrayList<>();
        helper(0, -1, graph, starts, targets, indexes);
        if (starts[0] != targets[0]) {
            return List.of(-1);
        }
        Collections.sort(indexes);
        return indexes;
    }

    public void helper(int node, int parent, List<List<int[]>> graph, char[] starts, char[] targets, List<Integer> indexes) {
        for (int[] entry : graph.get(node)) {
            int v = entry[0];
            int edgeIndex = entry[1];
            if (v == parent) {
                continue;
            }
            helper(v, node, graph, starts, targets, indexes);
            if (starts[v] != targets[v]) {
                indexes.add(edgeIndex);
                starts[v] = flip(starts[v]);
                starts[node] = flip(starts[node]);
            }
        }
    }

    private char flip(char c) {
        return c == '0' ? '1' : '0';
    }
}
