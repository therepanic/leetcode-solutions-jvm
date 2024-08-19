package graph2316;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public long countPairs(int n, int[][] edges) {
        if (n == 1) {
            return 0;
        }

        List<List<Integer>> allPairNodes = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> checked = new HashSet<>();

        int allPairNodesIndex = 0;
        for (int i = 0; i < n; i++) {
            if (!checked.contains(i)) {
                allPairNodes.add(new ArrayList<>());
                helper(graph, allPairNodes, allPairNodesIndex, i, checked);
                allPairNodesIndex++;
            }
        }

        long count = 0;
        int totalSize = 0;

        for (List<Integer> allPairNode : allPairNodes) {
            totalSize += allPairNode.size();
        }

        for (List<Integer> allPairNode : allPairNodes) {
            totalSize -= allPairNode.size();
            count += (long) allPairNode.size() * totalSize;
        }

        return count;
    }

    public static void helper(List<List<Integer>> graph, List<List<Integer>> allPairNodes, int allPairNodesIndex,
                              int currentNode, Set<Integer> checked) {
        checked.add(currentNode);
        allPairNodes.get(allPairNodesIndex).add(currentNode);

        for (int node : graph.get(currentNode)) {
            if (!checked.contains(node)) {
                helper(graph, allPairNodes, allPairNodesIndex, node, checked);
            }
        }
    }
}
