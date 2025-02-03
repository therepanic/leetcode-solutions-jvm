package possibleBipartition;

import java.util.*;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colour = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (colour[i] == 0) {
                if (!bypass(colour, i, graph, queue)) return false;
            }
        }
        return true;
    }
    public boolean bypass(int[] colour, int n, List<List<Integer>> graph, Queue<Integer> queue) {
        colour[n] = 1;
        queue.add(n);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int node : graph.get(poll)) {
                if (colour[node] == colour[poll]) {
                    return false;
                } else if (colour[node] == 0){
                    colour[node] = colour[poll] == 1 ? 2 : 1;
                    queue.add(node);
                }
            }
        }
        return true;
    }
}
