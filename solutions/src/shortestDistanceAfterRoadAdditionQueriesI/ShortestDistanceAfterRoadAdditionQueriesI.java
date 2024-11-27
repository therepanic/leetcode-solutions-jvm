package shortestDistanceAfterRoadAdditionQueriesI;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            if (i + 1 == n) {
                graph.add(new ArrayList<>());
            } else {
                graph.add(new ArrayList<>(List.of(i + 1)));
            }
            distances[i] = i;
        }

        int[] answer = new int[queries.length];
        int it = 0;

        for (int[] query : queries) {
            graph.get(query[0]).add(query[1]);
            answer[it] = bypass(query[0], distances, graph);
            it++;
        }

        return answer;
    }

    public static int bypass(int node, int[] distances, List<List<Integer>> graph) {
        Queue<int[]> queue = new ArrayDeque<>(List.of(new int[] {node, distances[node]}));

        int min = distances[distances.length - 1];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] + 1 == graph.size()) {
                min = Math.min(min, distances[distances.length - 1]);
            }

            for (int curNode : graph.get(poll[0])) {
                if (poll[1] + 1 < distances[curNode]) {
                    queue.add(new int[] {curNode, poll[1] + 1});
                    distances[curNode] = poll[1] + 1;
                }
            }
        }

        return min;
    }
}
