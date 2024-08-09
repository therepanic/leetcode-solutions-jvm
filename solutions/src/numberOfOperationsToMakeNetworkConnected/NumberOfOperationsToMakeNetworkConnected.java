package numberOfOperationsToMakeNetworkConnected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length + 1 < n) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        Set<Integer> visited = new HashSet<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, graph);

                count++;
            }
        }
        return count - 1;
    }

    private void dfs(int node, Set<Integer> visited, List<List<Integer>> graph) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, graph);
            }
        }
    }

}
