package shortestBridge;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        firstLoop: for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    helper1(i, j, grid, queue);

                    break firstLoop;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] data = queue.poll();

            int n = data[0];
            int m = data[1];

            if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || grid[n][m] == -1) {
                continue;
            }

            if (grid[n][m] == 1) {
                return data[2] - 1;
            }

            grid[n][m] = -1;

            queue.add(new int[] {n - 1, m, data[2] + 1});
            queue.add(new int[] {n + 1, m, data[2] + 1});
            queue.add(new int[] {n, m + 1, data[2] + 1});
            queue.add(new int[] {n, m - 1, data[2] + 1});

        }

        return 0;
    }

    public void helper1(int n, int m, int[][] grid, Queue<int[]> queue) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[n].length || grid[n][m] == 0) {
            return;
        }

        grid[n][m] = 0;

        queue.add(new int[] {n, m, 0});

        helper1(n - 1, m, grid, queue);
        helper1(n + 1, m, grid, queue);
        helper1(n, m - 1, grid, queue);
        helper1(n, m + 1, grid, queue);
    }


}
