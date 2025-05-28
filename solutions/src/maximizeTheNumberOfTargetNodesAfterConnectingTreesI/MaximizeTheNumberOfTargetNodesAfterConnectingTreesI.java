package maximizeTheNumberOfTargetNodesAfterConnectingTreesI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxTargetNodes(new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}}, new int[][] {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}, 2)));
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> graph1 = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        for (int i = 0; i < n; i++) {
            graph1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            graph1.get(edge[0]).add(edge[1]);
            graph1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            graph2.get(edge[0]).add(edge[1]);
            graph2.get(edge[1]).add(edge[0]);
        }
        int[] sum1 = new int[n];
        int[] sum2 = new int[m];
        for (int i = 0 ; i < n; i++) {
            sum1[i] = bypass(i, 0, k, graph1, new boolean[n]);
        }
        for (int i = 0 ; i < m; i++) {
            sum2[i] = bypass(i, 0, k - 1, graph2, new boolean[m]);
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int s = sum1[i];
            for (int j = 0; j < m; j++) {
                answer[i] = Math.max(answer[i], s + sum2[j]);
            }
        }
        return answer;
    }

    private static int bypass(int node, int depth, int depthLimit,
                              List<List<Integer>> graph, boolean[] visited) {
        if (depth > depthLimit || visited[node]) {
            return 0;
        }
        visited[node] = true;
        int cnt = 1;
        for (int nei : graph.get(node)) {
            cnt += bypass(nei, depth + 1, depthLimit, graph, visited);
        }
        return cnt;
    }
}
