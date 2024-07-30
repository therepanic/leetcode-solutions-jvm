package minimumNumberOfVerticesToReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> smallestSetOfVertices = new ArrayList<>();
        boolean[] exist = new boolean[n];

        for (List<Integer> edge : edges) {
            exist[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!exist[i]) {
                smallestSetOfVertices.add(i);
            }
        }

        return smallestSetOfVertices;
    }
}
