package allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> steps = new ArrayList<>(List.of(0));

        helper(graph, allPath, steps, 0);

        return allPath;
    }

    public void helper(int[][] graph, List<List<Integer>> allPath, List<Integer> steps, int index) {
        if (index == graph.length - 1) {
            allPath.add(new ArrayList<>(steps));
            return;
        }

        for (int i = 0; i < graph[index].length; i++) {
            steps.add(graph[index][i]);
            helper(graph, allPath, steps, graph[index][i]);
            steps.remove(steps.size() - 1);
        }
    }
}
