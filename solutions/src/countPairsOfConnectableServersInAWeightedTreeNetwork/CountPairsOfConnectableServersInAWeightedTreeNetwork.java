package countPairsOfConnectableServersInAWeightedTreeNetwork;

import java.util.ArrayList;
import java.util.List;

public class CountPairsOfConnectableServersInAWeightedTreeNetwork {

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
            graph.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            answer[i] = bypass(i, graph, 0, signalSpeed, true, visited);
        }
        return answer;
    }

    public int bypass(int node, List<List<int[]>> graph, int path, int signalSpeed, boolean start, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        int count = 0;
        if (!start && path % signalSpeed == 0) {
            count++;
        }
        if (graph.get(node).size() <= 1 && start) {
            visited[node] = false;
            return 0;
        }
        List<Integer> sums = null;
        for (int[] v : graph.get(node)) {
            int permCount = bypass(v[0], graph, path + v[1], signalSpeed, false, visited);
            if (start) {
                if (sums == null) {
                    sums = new ArrayList<>(List.of(permCount));
                } else {
                    sums.add(permCount);
                }
            } else {
                count += permCount;
            }
        }
        visited[node] = false;
        if (start) {
            long S = 0, Q = 0;
            for (int x : sums) {
                S += x;
                Q += 1L * x * x;
            }
            return (int)((S * S - Q) / 2);
        }
        return count;
    }

}
