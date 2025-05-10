package maximumWeightedKEdgePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumWeightedKEdgePath {
    public static int maxWeight(int n, int[][] edges, int k, int t) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        int[][] count = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(count[i], -1);
        }
        int[] answer = { -1 };
        for (int i = 0; i < n; i++) {
            bypass(graph, i, 0, count, answer, k, t, 0);
        }
        return answer[0];
    }

    private static void bypass(List<List<int[]>> graph, int node, int weight, int[][] count, int[] answer, int k, int t, int c) {
        if (c == k) {
            if (weight < t) {
                answer[0] = Math.max(answer[0], weight);
            }
            return;
        }
        if (weight >= t) {
            return;
        }
        if (weight <= count[node][c]) {
            return;
        }
        count[node][c] = weight;
        for (int[] edge : graph.get(node)) {
            bypass(graph, edge[0], weight + edge[1], count, answer, k, t, c + 1);
        }
    }
}
