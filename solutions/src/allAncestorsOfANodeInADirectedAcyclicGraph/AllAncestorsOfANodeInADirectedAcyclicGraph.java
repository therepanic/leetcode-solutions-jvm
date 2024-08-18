package allAncestorsOfANodeInADirectedAcyclicGraph;

import java.util.*;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> ancestors = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> connectedGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
            graph.add(new ArrayList<>());
            connectedGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            connectedGraph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> edgesWithNoAncestors = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (connectedGraph.get(i).isEmpty()) {
                edgesWithNoAncestors.add(i);
            }
        }

        while (!edgesWithNoAncestors.isEmpty()) {
            int nodeWithNoAncestor = edgesWithNoAncestors.poll();

            //System.out.println(nodeWithNoAncestor);

            for (int connectedNodeValue : graph.get(nodeWithNoAncestor)) {
                connectedGraph.get(connectedNodeValue).remove(Integer.valueOf(nodeWithNoAncestor));

                ancestors.get(connectedNodeValue).add(nodeWithNoAncestor);
                ancestors.get(connectedNodeValue).addAll(ancestors.get(nodeWithNoAncestor));

                if (connectedGraph.get(connectedNodeValue).isEmpty()) {
                    edgesWithNoAncestors.add(connectedNodeValue);
                }
            }
        }

        return ancestors.stream()
                .map(f -> f.stream().toList()).toList();
    }
}
