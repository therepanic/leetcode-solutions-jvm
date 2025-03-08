package flowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        boolean[] checked = new boolean[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                bypass(graph, checked, answer, i);
            }
        }
        return answer;
    }

    private boolean bypass(List<List<Integer>> graph, boolean[] checked, int[] answer, int curNode) {
        if (checked[curNode]) return false;
        boolean ok = false;
        firstLoop: for (int i = 1; i <= 4; i++) {
            answer[curNode] = i;
            for (int node : graph.get(curNode)) {
                if (answer[node] == i) {
                    continue firstLoop;
                } else if (answer[node] == 0) {
                    if (!checked[node] && !bypass(graph, checked, answer, node)) {
                        continue firstLoop;
                    }
                }
            }
            ok = true;
            break;
        }
        if (!ok) {
            answer[curNode] = 0;
            checked[curNode] = false;
        }
        return ok;
    }
}
