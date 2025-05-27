package shortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {-1, -1}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfs = new ArrayDeque<>();
        if (grid[0][0] == 1) {
            return -1;
        }
        bfs.add(new int[] {0, 0, 1});
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if (poll[0] == grid.length - 1 && poll[1] == grid[0].length - 1) {
                return poll[2];
            }
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y] && grid[x][y] != 1) {
                    visited[x][y] = true;
                    bfs.add(new int[] {x, y, poll[2] + 1});
                }
            }
        }
        return -1;
    }
}
