package largestColorValueInADirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInADirectedGraph {

    public int topSort(List<List<Integer>> graph, char[] colorChars, int[] invar, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++) {
            if (invar[i] == 0) {
                queue.add(i);
            }
        }
        int nodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;
            int color = colorChars[node] - 'a';
            cnt[node][color]++;
            max = Math.max(max, cnt[node][color]);
            for (int v : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    cnt[v][c] = Math.max(cnt[v][c], cnt[node][c]);
                }
                invar[v]--;
                if (invar[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (nodes != n) {
            return -1;
        }
        return max;
    }

    public int largestPathValue(String colors, int[][] edges) {
        char[] colorChars = colors.toCharArray();
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] invar = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            invar[e[1]]++;
        }
        return topSort(graph, colorChars, invar, n);
    }
}
