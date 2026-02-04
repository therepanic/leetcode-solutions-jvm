package criticalConnectionsInANetwork;

import java.util.*;

public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int[] dist = new int[n];
        int[] lowest = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(lowest, Integer.MAX_VALUE);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(graph, dist, lowest, new int[1], 0, -1, answer);
        return answer;
    }

    public void dfs(List<List<Integer>> graph, int[] dist, int[] lowest, int[] t, int node, int parent, List<List<Integer>> bridge) {
        dist[node] = lowest[node] = t[0];
        t[0]++;
        for (int v : graph.get(node)) {
            if (dist[v] == Integer.MAX_VALUE) {
                dfs(graph, dist, lowest, t, v, node, bridge);
                lowest[node] = Math.min(lowest[node], lowest[v]);
                if (lowest[v] > dist[node]) {
                    bridge.add(List.of(node, v));
                }
            } else if (v != parent) {
                lowest[node] = Math.min(lowest[node], dist[v]);
            }
        }
    }

}
