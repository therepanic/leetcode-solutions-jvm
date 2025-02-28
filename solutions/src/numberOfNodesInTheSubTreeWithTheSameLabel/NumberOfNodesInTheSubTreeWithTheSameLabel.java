package numberOfNodesInTheSubTreeWithTheSameLabel;

import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] labelChars = labels.toCharArray();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] result = new int[n];
        bypass(0, graph, labelChars, result, new boolean[n]);
        return result;
    }
    private int[] bypass(int curNode, List<List<Integer>> graph, char[] labelChars, int[] result, boolean[] checked) {
        if (checked[curNode]) return null;
        checked[curNode] = true;
        int[] answer = new int[26];
        answer[labelChars[curNode] - 'a']++;
        for (int node : graph.get(curNode)) {
            int[] poll = bypass(node, graph, labelChars, result, checked);
            if (poll == null) continue;
            for (int i = 0; i < 26; i++) {
                answer[i] += poll[i];
            }
        }
        result[curNode] = answer[labelChars[curNode] - 'a'];
        return answer;
    }
}
