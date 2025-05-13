package designGraphWithShortestPathCalculator;

import java.util.*;

public class Graph {

    private final List<List<int[]>> graph;

    public Graph(int n, int[][] edges) {
        this.graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> fast = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        fast.add(new int[] {node1, 0});
        int[] already = new int[graph.size()];
        Arrays.fill(already, Integer.MAX_VALUE);
        while (!fast.isEmpty()) {
            int[] poll = fast.poll();
            if (already[poll[0]] < poll[1]) {
                continue;
            }
            already[poll[0]] = poll[1];
            if (poll[0] == node2) {
                return poll[1];
            }
            for (int[] v : graph.get(poll[0])) {
                fast.add(new int[] {v[0], poll[1] + v[1]});
            }
        }
        return -1;
    }
}
