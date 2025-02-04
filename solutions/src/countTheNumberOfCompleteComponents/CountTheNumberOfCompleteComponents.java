package countTheNumberOfCompleteComponents;

import java.util.*;

public class CountTheNumberOfCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] checked = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (checked[i]) continue;
            List<Integer> nodes = new ArrayList<>();
            int c = count(i, graph, checked, nodes);
            boolean ok = true;
            for (int node : nodes) {
                if (graph.get(node).size() != c - 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }

    public int count(int node, List<List<Integer>> graph, boolean[] checked, List<Integer> nodes) {
        if (checked[node]) return 0;
        checked[node] = true;
        nodes.add(node);
        int count = 1;
        for (int curNode : graph.get(node)) {
            count += count(curNode, graph, checked, nodes);
        }
        return count;
    }
}
