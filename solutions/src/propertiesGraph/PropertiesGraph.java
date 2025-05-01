package propertiesGraph;

import java.util.*;

public class PropertiesGraph {
    public int numberOfComponents(int[][] properties, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            graph.add(new ArrayList<>());
        }
        List<Set<Integer>> cached = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            Set<Integer> cache = new HashSet<>();
            for (int j = 0; j < properties[0].length; j++) {
                cache.add(properties[i][j]);
            }
            cached.add(cache);
        }
        for (int i = 0; i < properties.length; i++) {
            Set<Integer> cached1 = cached.get(i);
            for (int j = i + 1; j < properties.length; j++) {
                Set<Integer> common = new HashSet<>();
                for (int comma : cached.get(j)) {
                    if (cached1.contains(comma)) {
                        common.add(comma);
                    }
                }
                for (int comma : cached1) {
                    if (cached.get(j).contains(comma)) {
                        common.add(comma);
                    }
                }
                if (common.size() >= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int c = 0;
        boolean[] visited = new boolean[properties.length];
        for (int i = 0; i < properties.length; i++) {
            if (!visited[i]) {
                bypass(i, graph, visited);
                c++;
            }
        }
        return c;
    }

    private void bypass(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int v : graph.get(node)) {
            bypass(v, graph, visited);
        }
    }
}
