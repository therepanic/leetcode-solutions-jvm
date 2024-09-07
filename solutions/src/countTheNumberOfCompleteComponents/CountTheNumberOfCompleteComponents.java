package countTheNumberOfCompleteComponents;

import java.util.*;

public class CountTheNumberOfCompleteComponents {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
            graph.get(edges[i][1]).add(new int[] {edges[i][0], edges[i][2]});
        }

        int[] minimumTime = new int[n];
        Arrays.fill(minimumTime, Integer.MAX_VALUE);
        minimumTime[0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        priorityQueue.add(new int[] {0, 0});

        boolean[] visited = new boolean[n];

        while (!priorityQueue.isEmpty()) {
            int[] edge = priorityQueue.poll();

            int nextNode = edge[0];
            int currentTime = edge[1];

            if (visited[nextNode]) continue;

            visited[nextNode] = true;

            if (currentTime >= disappear[nextNode]) {
                continue;
            }

            for (int[] node : graph.get(nextNode)) {
                int newTime = node[1] + currentTime;

                if (newTime < disappear[node[0]] && newTime < minimumTime[node[0]]) {
                    minimumTime[node[0]] = newTime;

                    priorityQueue.add(new int[] {node[0], newTime});
                }
            }
        }


        for (int i = 0; i < minimumTime.length; i++) {
            if (minimumTime[i] > disappear[i]) {
                minimumTime[i] = -1;
            }
        }

        return minimumTime;
    }
}
