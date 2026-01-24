package minimumCostPathWithEdgeReversals;

import java.util.*;

public class MinimumCostPathWithEdgeReversals {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>(edges.length + 1);
        List<List<int[]>> reversed = new ArrayList<>(edges.length + 1);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
            reversed.get(edges[i][1]).add(new int[] {edges[i][0], edges[i][2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        heap.add(new int[] {0, 0});
        int[] stat = new int[n];
        Arrays.fill(stat, Integer.MAX_VALUE);
        while (!heap.isEmpty()) {
            int[] entry = heap.poll();
            if (entry[1] >= stat[entry[0]]) {
                continue;
            }
            stat[entry[0]] = entry[1];
            if (entry[0] == n - 1) {
                return entry[1];
            }
            for (int[] v : graph.get(entry[0])) {
                int w =  entry[1] + v[1];
                if (w >= stat[v[0]]) {
                    continue;
                }
                heap.add(new int[] {v[0], w});
            }
            for (int[] v : reversed.get(entry[0])) {
                int w =  entry[1] + 2 * v[1];
                if (w >= stat[v[0]]) {
                    continue;
                }
                heap.add(new int[] {v[0], w});
            }
        }
        return -1;
    }
}
