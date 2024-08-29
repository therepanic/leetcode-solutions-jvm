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

        long[] answer = new long[1];
        int[] steps = new int[1];

        helper2(0, graph, nodeCountMap, answer, steps);

        return steps[0];
    }

    public void helper2(int value, List<List<Integer>> graph, Map<Integer, Integer> nodeCountMap, long[] answer, int[] steps) {
        int leftNodeSize = 0;
        int rightNodeSize = 0;
        int upNodeSize = nodeCountMap.get(0) - 1;

        if (!graph.get(value).isEmpty()) {
            leftNodeSize = nodeCountMap.get(graph.get(value).get(0));
        }

        if (graph.get(value).size() >= 2) {
            rightNodeSize = nodeCountMap.get(graph.get(value).get(1));
        }

        upNodeSize -= leftNodeSize + rightNodeSize;

        upNodeSize = upNodeSize == 0 ? 1 : upNodeSize;
        leftNodeSize = leftNodeSize == 0 ? 1 : leftNodeSize;
        rightNodeSize = rightNodeSize == 0 ? 1 : rightNodeSize;

        long newAnswer = (long) leftNodeSize * rightNodeSize * upNodeSize;

        if (newAnswer > answer[0]) {
            answer[0] = newAnswer;

            steps[0] = 1;
        } else if (newAnswer == answer[0]) {
            steps[0]++;
        }

        for (int node : graph.get(value)) {
            helper2(node, graph, nodeCountMap, answer, steps);
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
