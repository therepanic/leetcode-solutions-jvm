package findEventualSafeStates;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] graphListLength = new int[graph.length];
        List<List<Integer>> invertedGraph = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            invertedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int value : graph[i]) {
                graphListLength[i]++;
                invertedGraph.get(value).add(i);
            }
        }

        Queue<Integer> graphWithoutIncomingEdges = new ArrayDeque<>();

        for (int i = 0; i < invertedGraph.size(); i++) {
            if (graphListLength[i] == 0) {
                graphWithoutIncomingEdges.add(i);
            }
        }

        List<Integer> graphNodeList = new ArrayList<>();

        while (!graphWithoutIncomingEdges.isEmpty()) {
            int graphWithoutIncomingEdgesValue = graphWithoutIncomingEdges.poll();

            graphNodeList.add(graphWithoutIncomingEdgesValue);

            for (int value : invertedGraph.get(graphWithoutIncomingEdgesValue)) {
                graphListLength[value]--;
                if (graphListLength[value] == 0) {
                    graphWithoutIncomingEdges.add(value);
                }
            }
        }

        Collections.sort(graphNodeList);

        return graphNodeList;
    }
}
