package isGraphBipartite;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> current = new ArrayDeque<>();
        int[] colours = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colours[i] == 0) {
                boolean ok = isBipartite(current, graph, colours, i);
                if (!ok) return false;
            }
        }
        return true;
    }

    public boolean isBipartite(Queue<Integer> current, int[][] graph, int[] colours, int start) {
        current.add(start);
        colours[start] = 1;
        while (!current.isEmpty()) {
            int poll = current.poll();
            for (int node : graph[poll]) {
                if (colours[node] == colours[poll]) {
                    return false;
                } else if (colours[node] == 0) {
                    colours[node] = colours[poll] == 1 ? 2 : 1;
                    current.add(node);
                }
            }
        }
        return true;
    }
}
