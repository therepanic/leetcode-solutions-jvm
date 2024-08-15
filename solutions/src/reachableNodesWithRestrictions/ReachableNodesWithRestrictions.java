package reachableNodesWithRestrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> edgeList = new ArrayList<>();
        int[] reachableNodes = new int[1];

        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> restrictedSet = new HashSet<>();

        for (int value : restricted) {
            restrictedSet.add(value);
        }

        dfs(edgeList, 0, restrictedSet, reachableNodes);

        return reachableNodes[0];
    }

    public void dfs(List<List<Integer>> edgeList, int currentNode, Set<Integer> restricted, int[] reachableNodes) {
        restricted.add(currentNode);
        reachableNodes[0]++;

        for (int node : edgeList.get(currentNode)) {
            if (!restricted.contains(node)) {
                dfs(edgeList, node, restricted, reachableNodes);
            }
        }
    }
}
