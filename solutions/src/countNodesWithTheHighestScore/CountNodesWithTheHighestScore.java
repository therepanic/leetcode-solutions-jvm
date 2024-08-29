package countNodesWithTheHighestScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNodesWithTheHighestScore {
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, Integer> nodeCountMap = new HashMap<>();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < parents.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < parents.length; i++) {
            graph.get(parents[i]).add(i);
        }

        helper1(0, graph, nodeCountMap);

        System.out.println(graph);
        System.out.println(nodeCountMap);

        int[] answer = new int[2];

        helper2(0, graph, nodeCountMap, answer);

        return answer[1];
    }

    public void helper2(int value, List<List<Integer>> graph, Map<Integer, Integer> nodeCountMap, int[] answer) {
        int leftNodeSize = 0;
        int rightNodeSize = 0;
        int upNodeSize = nodeCountMap.get(0);

        if (!graph.get(value).isEmpty() && graph.get(value).get(0) != null) {
            leftNodeSize = nodeCountMap.get(graph.get(value).get(0));
        }

        if (graph.get(value).size() >= 2 && graph.get(value).get(1) != null) {
            rightNodeSize = nodeCountMap.get(graph.get(value).get(1));
        }

        upNodeSize -= leftNodeSize + rightNodeSize + 1;

        if (upNodeSize == 0) {
            upNodeSize = 1;
        }

        if (leftNodeSize == 0) {
            leftNodeSize = 1;
        }

        if (rightNodeSize == 0) {
            rightNodeSize = 1;
        }

        System.out.println(leftNodeSize + " " + rightNodeSize + " " + upNodeSize + value);

        int newAnswer = Math.max(answer[0], leftNodeSize * rightNodeSize * upNodeSize);

        if (newAnswer > answer[0]) {
            answer[0] = newAnswer;

            answer[1] = 1;
        } else if (newAnswer == answer[0]) {
            answer[1]++;
        }

        for (int node : graph.get(value)) {
            helper2(node, graph, nodeCountMap, answer);
        }
    }

    public int helper1(int value, List<List<Integer>> graph, Map<Integer, Integer> nodeCountMap) {
        int size = 1;

        for (int node : graph.get(value)) {
            size += helper1(node, graph, nodeCountMap);
        }

        nodeCountMap.put(value, size);

        return size;
    }
}
