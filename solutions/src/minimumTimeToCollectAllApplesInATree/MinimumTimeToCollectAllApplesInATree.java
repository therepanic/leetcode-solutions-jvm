package minimumTimeToCollectAllApplesInATree;

import java.util.*;

public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] banned = new boolean[n];
        bypassCanceled(0, -1, graph, hasApple, banned);
        return bypassTime(0, -1, graph, banned, hasApple);
    }

    public int bypassTime(int node, int parent, List<List<Integer>> graph, boolean[] banned, List<Boolean> hasApple) {
        if (banned[node]) return 0;
        int count = 0;
        for (int curNode : graph.get(node)) {
            if (curNode == parent) continue;
            count += bypassTime(curNode, node, graph, banned, hasApple);
        }
        if ((count > 0 || hasApple.get(node)) && node != 0) {
            count += 2;
        }
        return count;
    }

    public boolean bypassCanceled(int node, int parent, List<List<Integer>> graph, List<Boolean> hasApple, boolean[] banned) {
        boolean hasAppleHere = hasApple.get(node);
        for (int curNode : graph.get(node)) {
            if (curNode == parent) continue;
            if (bypassCanceled(curNode, node, graph, hasApple, banned)) {
                hasAppleHere = true;
            }
        }
        banned[node] = !hasAppleHere;
        return hasAppleHere;
    }
}