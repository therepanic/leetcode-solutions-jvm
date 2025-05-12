package findClosestNodeToGivenTwoNodes;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] distance1 = new int[edges.length];
        int[] distance2 = new int[edges.length];
        Arrays.fill(distance1, -1);
        Arrays.fill(distance2, -1);
        bypass(edges, node1, 0, distance1, new boolean[edges.length]);
        bypass(edges, node2, 0, distance2, new boolean[edges.length]);
        int it = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < distance1.length; i++) {
            if (distance1[i] == -1 || distance2[i] == -1) continue;
            int maxVal = Math.max(distance1[i], distance2[i]);
            if (maxVal < distance) {
                distance = maxVal;
                it = i;
            }
        }
        return it == Integer.MAX_VALUE ? -1 : it;
    }
    public void bypass(int[] edges, int node, int distance, int[] distances, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        distances[node] = distance;
        if (edges[node] == -1) return;
        bypass(edges, edges[node], distance + 1, distances, visited);
    }
}
