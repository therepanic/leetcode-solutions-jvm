package detonateTheMaximumBombs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int maxCount = 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                double distance = Math.pow(bombs[i][0] - bombs[j][0], 2) + (Math.pow(bombs[i][1] - bombs[j][1], 2));
                if (distance <= Math.pow(bombs[i][2], 2)) {
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] checked = new boolean[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            maxCount = Math.max(maxCount, bypass(graph, i, checked));
            Arrays.fill(checked, false);
        }
        return maxCount;
    }

    private int bypass(List<List<Integer>> graph, int curNode, boolean[] checked) {
        if (checked[curNode]) return 0;
        checked[curNode] = true;
        int count = 1;
        for (int node : graph.get(curNode)) {
            count += bypass(graph, node, checked);
        }
        return count;
    }
}
