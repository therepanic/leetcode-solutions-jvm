package maximizeTheNumberOfTargetNodesAfterConnectingTreesII;

import java.util.*;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> graph1 = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        for (int i = 0; i < n; i++) {
            graph1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            graph1.get(edge[0]).add(edge[1]);
            graph1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            graph2.get(edge[0]).add(edge[1]);
            graph2.get(edge[1]).add(edge[0]);
        }
        Set<Integer> firstEven = new HashSet<>();
        Set<Integer> firstNonEven = new HashSet<>();
        boolean[] visited1 = new boolean[n];
        bypass(0, false, graph1, visited1, firstEven);
        bypass(0, true, graph1, visited1, firstNonEven);
        Set<Integer> secondEven = new HashSet<>();
        Set<Integer> secondNonEven = new HashSet<>();
        boolean[] visited2 = new boolean[m];
        bypass(0, false, graph2, visited2, secondEven);
        bypass(0, true, graph2, visited2, secondNonEven);
        int[] answer = new int[n];
        int it = 0;
        for (int i = 0; i < n; i++) {
            if (firstEven.contains(i)) {
                answer[it] = firstEven.size() + Math.max(secondEven.size(), secondNonEven.size());
            } else {
                answer[it] = firstNonEven.size() + Math.max(secondEven.size(), secondNonEven.size());
            }
            it++;
        }
        return answer;
    }

    public static void bypass(int node, boolean even, List<List<Integer>> graph, boolean[] visited, Set<Integer> values) {
        if (visited[node]) {
            return;
        }
        if (even) {
            values.add(node);
        }
        visited[node] = true;
        for (int v : graph.get(node)) {
            bypass(v, !even, graph, visited, values);
        }
        visited[node] = false;
    }

}
