package secondMinimumTimeToReachDestination;

import java.util.*;

public class SecondMinimumTimeToReachDestination {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0] - 1).add(edges[i][1] - 1);
            graph.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }
        int[] minTime = new int[n];
        int[] minTimeTwo = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        Arrays.fill(minTimeTwo, Integer.MAX_VALUE);
        boolean already = false;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        queue.add(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[1] < minTime[node[0]]) {
                minTimeTwo[node[0]] = minTime[node[0]];
                minTime[node[0]] = node[1];
            } else if (node[1] < minTimeTwo[node[0]] && node[1] > minTime[node[0]]) {
                minTimeTwo[node[0]] = node[1];
            } else {
                continue;
            }
            if (node[0] == n - 1) {
                if (already) {
                    return node[1];
                }
                already = true;
            }
            int depart = fix(node[1], change);
            int t = depart + time;
            for (int v : graph.get(node[0])) {
                if (t < minTime[v] || (t > minTime[v] && t < minTimeTwo[v])) {
                    queue.add(new int[] {v, t});
                }
            }
        }
        return -1;
    }

    public static int fix(int n, int k) {
        int block = n / k;
        if (block % 2 == 0 && n % k != 0) return n;
        return ((block + 1) / 2 * 2) * k;
    }
}
