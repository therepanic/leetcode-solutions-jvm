package theTimeWhenTheNetworkBecomesIdle;

import java.util.*;

public class TheTimeWhenTheNetworkBecomesIdle {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> bfs = new ArrayDeque<>(List.of(new int[] {0, 0}));
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if (visited[poll[0]] <= poll[1]) {
                continue;
            }
            visited[poll[0]] = poll[1];
            for (int v : graph.get(poll[0])) {
                bfs.add(new int[] {v, poll[1] + 1});
            }
        }
        int time = 0;
        for (int i = 1; i < visited.length; i++) {
            int d = visited[i] * 2;
            if (d <= patience[i]) {
                time = Math.max(time, d);
            } else {
                time = Math.max(time, patience[i] * ((d - 1) / patience[i]) + d);
            }
        }
        return time + 1;
    }

}
