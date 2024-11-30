package validArrangementOfPairs;

import java.util.*;

public class ValidArrangementOfPairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], k -> new LinkedList<>()).add(pair[1]);

            in.put(pair[1], in.getOrDefault(pair[1], 0) + 1);
            out.put(pair[0], out.getOrDefault(pair[0], 0) + 1);
        }
        int start = pairs[0][0];


        for (int key : graph.keySet()) {
            if (out.get(key) > in.getOrDefault(key, 0)) {
                start = key;
                break;
            }
        }

        List<int[]> preAnswer = new ArrayList<>();
        dfs(preAnswer, start, graph);
        Collections.reverse(preAnswer);
        int[][] answer = new int[preAnswer.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = preAnswer.get(i);
        }
        return answer;
    }

    public void dfs(List<int[]> answer, int node, Map<Integer, List<Integer>> graph) {
        while (graph.containsKey(node) && !graph.get(node).isEmpty()) {
            int nextNode = graph.get(node).removeLast();
            dfs(answer, nextNode, graph);
            answer.add(new int[]{node, nextNode});
        }
    }

}
