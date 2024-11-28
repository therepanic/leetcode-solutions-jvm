package minimumFuelCostToReportToTheCapital;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    public static long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < roads.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        long[] answer = new long[1];

        dfs(0, seats, graph, new boolean[roads.length + 1], answer);

        return answer[0];
    }

    public static long dfs(int node, int seats, List<List<Integer>> graph, boolean[] visited, long[] answer) {
        if (visited[node]) return 0;
        visited[node] = true;

        long count = 1;
        for (int curNode : graph.get(node)) {
            count += dfs(curNode, seats, graph, visited, answer);
        }

        if (node != 0) {
            answer[0] += (count + seats - 1) / seats;
        }

        return count;
    }
}
