package shortestPathWithAlternatingColors;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Queue<int[]> bfs = new ArrayDeque<>(List.of(new int[] {0, 0, -1}));
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new int[] {edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new int[] {edge[1], 1});
        }
        int[] score = new int[n];
        Arrays.fill(score, Integer.MAX_VALUE);
        boolean[] blueVisited = new boolean[n];
        boolean[] redVisited = new boolean[n];
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if ((poll[2] == 0 && redVisited[poll[0]] || poll[2] == 1 && blueVisited[poll[0]]) && score[poll[0]] <= poll[1]) continue;
            if (poll[2] == 0) {
                redVisited[poll[0]] = true;
            } else if (poll[2] == 1) {
                blueVisited[poll[0]] = false;
            }
            score[poll[0]] = Math.min(score[poll[0]], poll[1]);
            for (int[] edge : graph.get(poll[0])) {
                if (edge[1] == 0 && (poll[2] == -1 || poll[2] == 1)) {
                    bfs.add(new int[] {edge[0], poll[1] + 1, 0});
                } else if (edge[1] == 1 && (poll[2] == -1 || poll[2] == 0)) {
                    bfs.add(new int[] {edge[0], poll[1] + 1, 1});
                }
            }
        }
        for (int i = 0; i < score.length; i++) {
            if (score[i] == Integer.MAX_VALUE) {
                score[i] = -1;
            }
        }
        return score;
    }
}
