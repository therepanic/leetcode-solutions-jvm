package numberOfRestrictedPathsFromFirstToLastNode;

import java.util.*;

public class NumberOfRestrictedPathsFromFirstToLastNode {

    public int countRestrictedPaths(int n, int[][] edges) {
        int m = n;
        List<List<int[]>> graph = new ArrayList<>();
        n--;
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(new int[] {edge[1] - 1, edge[2]});
            graph.get(edge[1] - 1).add(new int[] {edge[0] - 1, edge[2]});
        }
        int[] distance = new int[m];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        heap.add(new int[] {n, 0});
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (distance[poll[0]] <= poll[1]) {
                continue;
            }
            distance[poll[0]] = poll[1];
            for (int[] v : graph.get(poll[0])) {
                heap.add(new int[] {v[0], v[1] + poll[1]});
            }
        }
        long[] visited = new long[m];
        Arrays.fill(visited, -1);
        return (int) dfs(graph, distance, visited, n);
    }

    public long dfs(List<List<int[]>> graph, int[] distance, long[] visited, int node) {
        if (visited[node] != -1) {
            return visited[node];
        }
        if (node == 0) {
            return 1;
        }
        long sum = 0;
        for (int[] v : graph.get(node)) {
            if (distance[node] < distance[v[0]]) {
                sum = (sum + dfs(graph, distance, visited, v[0])) % 1_000_000_007;
            }
        }
        visited[node] = sum;
        return sum;
    }

}
