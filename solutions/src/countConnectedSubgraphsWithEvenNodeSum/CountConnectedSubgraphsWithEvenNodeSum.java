package countConnectedSubgraphsWithEvenNodeSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CountConnectedSubgraphsWithEvenNodeSum {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = 0;
        for (int mask = (1 << n) - 1; mask >= 1; mask--) {
            int start = -1;
            int sum = 0;
            for (int p = 0; p < 14; p++) {
                if ((mask & (1 << p)) != 0) {
                    start = p;
                    sum += nums[p];
                }
            }
            if ((sum & 1) != 0) continue;
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>(List.of(start));
            visited[start] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph.get(u)) {
                    if ((mask & (1 << v)) != 0 && !visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && !visited[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }
        return ans;
    }
}
