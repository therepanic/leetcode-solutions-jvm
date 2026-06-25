package shortestPathWithAtMostKConsecutiveIdenticalCharacters;

import java.util.*;

public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
        }
        char[] labelChars = labels.toCharArray();
        heap.add(new int[] {0, 0, 0, 27});
        boolean[][][] visited = new boolean[n][k + 1][26];
        while (!heap.isEmpty()) {
            int[] best = heap.poll();
            if ((char) (best[3] + 'a') == labelChars[best[0]]) {
                best[2]++;
            } else {
                best[3] = labelChars[best[0]] - 'a';
                best[2] = 1;
            }
            if (best[2] > k) {
                continue;
            }
            if (visited[best[0]][best[2]][best[3]]) {
                continue;
            }
            visited[best[0]][best[2]][best[3]] = true;
            if (best[0] == n - 1) {
                return best[1];
            }
            for (int[] v : graph.get(best[0])) {
                int c = best[1] + v[1];
                if (!visited[v[0]][best[2]][best[3]]) {
                    heap.add(new int[] {v[0], c, best[2], best[3]});
                }
            }
        }
        return -1;
    }
}
