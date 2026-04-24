package multiSourceFloodFill;

import java.util.*;

public class MultiSourceFloodFill {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Queue<int[]> bfs = new ArrayDeque<>();
        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int[] src : sources) {
            bfs.add(new int[]{src[0], src[1], src[2]});
            grid[src[0]][src[1]] = Math.max(grid[src[0]][src[1]], src[2]);
            dist[src[0]][src[1]] = 0;
        }
        int[] x = new int[] {-1, 1, 0, 0};
        int[] y = new int[] {0, 0, -1, 1};
        int step = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            step++;
            Map<Integer, int[]> nextMap = new HashMap<>();
            for (int c = 0; c < size; c++) {
                int[] poll = bfs.poll();
                for (int i = 0; i < 4; i++) {
                    int p = poll[0] + x[i];
                    int l = poll[1] + y[i];
                    if (p >= 0 && l >= 0 && p < n && l < m) {
                        if (dist[p][l] == -1) {
                            dist[p][l] = step;
                            grid[p][l] = poll[2];
                            int key = p * m + l;
                            if (!nextMap.containsKey(key)) {
                                nextMap.put(key, new int[]{p, l, poll[2]});
                            } else {
                                int[] existing = nextMap.get(key);
                                existing[2] = Math.max(existing[2], poll[2]);
                                grid[p][l] = existing[2];
                            }
                        } else if (dist[p][l] == step) {
                            int key = p * m + l;
                            int[] existing = nextMap.get(key);
                            if (existing != null) {
                                existing[2] = Math.max(existing[2], poll[2]);
                                grid[p][l] = existing[2];
                            }
                        }
                    }
                }
            }
            bfs.addAll(nextMap.values());
        }
        return grid;
    }
}
