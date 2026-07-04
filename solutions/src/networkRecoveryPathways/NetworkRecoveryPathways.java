package networkRecoveryPathways;

import java.util.*;

public class NetworkRecoveryPathways {

    public boolean cai(List<List<int[]>> graph, boolean[] online, long k, int x) {
        int n = online.length;
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(p -> p[1]));
        heap.add(new long[]{0, 0});
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        while (!heap.isEmpty()) {
            long[] poll = heap.poll();
            int id = (int) poll[0];
            long weight = poll[1];
            if (!online[id] || weight > k || weight != dist[id]) {
                continue;
            }
            if (id == n - 1) {
                return true;
            }
            for (int[] v : graph.get(id)) {
                int next = v[0];
                int edgeCost = v[1];
                if (!online[next]) {
                    continue;
                }
                if (edgeCost < x) {
                    continue;
                }
                long newWeight = weight + edgeCost;
                if (newWeight > k) {
                    continue;
                }
                if (newWeight < dist[next]) {
                    dist[next] = newWeight;
                    heap.add(new long[]{next, newWeight});
                }
            }
        }
        return false;
    }


    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
        }
        int left = 0;
        int right = 0;
        for (int[] e : edges) {
            right = Math.max(right, e[2]);
        }
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (cai(graph, online, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
