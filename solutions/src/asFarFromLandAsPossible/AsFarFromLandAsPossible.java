package asFarFromLandAsPossible;

import java.util.ArrayDeque;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    public static int maxDistance(int[][] grid) {
        Queue<int[]> bfs = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    bfs.add(new int[] {i, j});
                }
            }
        }
        if (bfs.isEmpty() || bfs.size() == grid.length * grid[0].length) {
            return -1;
        }
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dist = -1;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int[] poll = bfs.poll();
                for (int[] d : dir) {
                    int x = poll[0] + d[0];
                    int y = poll[1] + d[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1 || grid[x][y] != 0) {
                        continue;
                    }
                    grid[x][y] = -1;
                    bfs.add(new int[] {x, y});
                }
            }
            dist++;
        }
        return dist;
    }

}
