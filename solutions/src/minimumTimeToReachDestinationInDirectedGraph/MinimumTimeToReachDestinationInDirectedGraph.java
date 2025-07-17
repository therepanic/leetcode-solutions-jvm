package minimumTimeToReachDestinationInDirectedGraph;

import java.util.*;

public class MinimumTimeToReachDestinationInDirectedGraph {

    public int minTime(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2], edge[3]});
        }
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        PriorityQueue<int[]> heap =  new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        heap.add(new int[] {0, 0});
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (poll[0] == n - 1) {
                return poll[1];
            }
            if (minTime[poll[0]] < poll[1]) continue;
            minTime[poll[0]] = poll[1];
            for (int[] v : graph.get(poll[0])) {
                if (poll[1] < v[1]) {
                    heap.add(new int[] {v[0], v[1] + 1});
                } else if (poll[1] <= v[2]){
                    heap.add(new int[] {v[0], poll[1] + 1});
                }
            }
        }
        return -1;
    }

}
