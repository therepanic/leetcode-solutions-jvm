package numberOfWaysToArriveAtDestination;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        long[] paths = new long[n];
        long[] pathShortestWeight = new long[n];
        Arrays.fill(pathShortestWeight, Long.MAX_VALUE);
        pathShortestWeight[0] = 0;
        paths[0] = 1;
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new long[] {road[1], road[2]});
            graph.get(road[1]).add(new long[] {road[0], road[2]});
        }
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(p -> p[1]));
        heap.add(new long[] {0, 0});
        while (!heap.isEmpty()) {
            long[] poll = heap.poll();
            int curNode = (int) poll[0];
            if (poll[1] > pathShortestWeight[curNode]) {
                continue;
            }
            for (long[] edge : graph.get(curNode)) {
                int nNode = (int) edge[0];
                if (edge[1] + poll[1] < pathShortestWeight[nNode]) {
                    pathShortestWeight[nNode] = edge[1] + poll[1];
                    paths[nNode] = paths[curNode];
                    heap.add(new long[] {nNode, pathShortestWeight[nNode]});
                } else if (edge[1] + poll[1] == pathShortestWeight[nNode]) {
                    paths[nNode] = (long) ((paths[curNode] + paths[nNode])  % (1e9 + 7));
                }
            }
        }
        return (int) paths[n - 1];
    }
}
