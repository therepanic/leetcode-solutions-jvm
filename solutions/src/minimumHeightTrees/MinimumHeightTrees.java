package minimumHeightTrees;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int queueSize = queue.size();
            n -= queueSize;

            for (int i = 0; i < queueSize; i++) {
                int firstValue = queue.poll();

                for (int node : graph.get(firstValue)) {
                    graph.get(node).remove(Integer.valueOf(firstValue));

                    if (graph.get(node).size() == 1) {
                        queue.add(node);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
