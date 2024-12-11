package reorderRoutesToMakeAllPathsLeadToTheCityZero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> graphReversed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            graphReversed.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);

            graphReversed.get(connection[1]).add(connection[0]);
        }

        int[] count = new int[1];

        helper(0, graph, graphReversed, count, new HashSet<>());

        return count[0];
    }

    public static boolean helper(int node, List<List<Integer>> graph, List<List<Integer>> graphReversed, int[] count, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for (int i = 0; i < graph.get(node).size(); i++) {
            int curNode = graph.get(node).get(i);

            if (helper(curNode, graph, graphReversed, count, visited)) {
                count[0]++;
            }
        }

        for (int curNode : graphReversed.get(node)) {
            helper(curNode, graph, graphReversed, count, visited);
        }

        visited.remove(node);

        return true;
    }
}
