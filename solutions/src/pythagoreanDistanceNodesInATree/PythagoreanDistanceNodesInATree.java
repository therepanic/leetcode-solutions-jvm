package pythagoreanDistanceNodesInATree;

import java.util.*;

public class PythagoreanDistanceNodesInATree {

    public void bypass(int node, List<List<Integer>> graph, boolean[] checked, int[][] distances, int distance, int b) {
        if (checked[node]) return;
        checked[node] = true;
        distances[b][node] = distance;
        for (int v : graph.get(node)) {
            bypass(v, graph, checked, distances, distance + 1, b);
        }
    }


    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[][] distances = new int[3][n];
        boolean[] checked = new boolean[n];
        bypass(x, graph, checked, distances, 0, 0);
        Arrays.fill(checked, false);
        bypass(y, graph, checked, distances, 0, 1);
        Arrays.fill(checked, false);
        bypass(z, graph, checked, distances, 0, 2);
        int c = 0;
        for (int i = 0; i < n; i++) {
            int[] values = new int[] {distances[0][i], distances[1][i], distances[2][i]};
            Arrays.sort(values);
            if ((long) values[0] * values[0] + (long) values[1] * values[1] == (long) values[2] * values[2]) {
                c++;
            }
        }
        return c;
    }
}
