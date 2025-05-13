package shortestCycleInAGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestCycleInAGraph {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int shortestCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Queue<int[]> bfs = new ArrayDeque<>();
            bfs.add(new int[] {i, -1, 0});
            while (!bfs.isEmpty()) {
                int[] poll = bfs.poll();
                if (poll[2] >= shortestCycle) break;
                if (poll[1] != -1 && poll[0] == i) {
                    shortestCycle = poll[2];
                    break;
                }
                for (int v : graph.get(poll[0])) {
                    if (poll[1] == -1 || poll[1] != v) {
                        bfs.add(new int[] {v, poll[0], poll[2] + 1});
                    }
                }
            }
        }
        return shortestCycle == Integer.MAX_VALUE ? -1 : shortestCycle;
    }
}
