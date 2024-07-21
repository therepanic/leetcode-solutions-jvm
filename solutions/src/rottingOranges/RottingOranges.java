package rottingOranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int orangesRottingCount = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean someThingChanged = false;

            for (int k = 0; k < queueSize; k++) {
                int[] pair = queue.peek();

                int i = pair[0];
                int j = pair[1];

                if (grid[i][j] == 0) {
                    break;
                }

                if (j < grid[i].length - 1 && grid[i][j + 1] == 1 || j < grid[i].length - 1 && grid[i][j] == 1) {
                    queue.add(new int[] {i, j + 1});

                    if (grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        someThingChanged = true;
                    }
                }

                if (i < grid.length - 1 && grid[i + 1][j] == 1 || i < grid.length - 1 && grid[i][j] == 1) {
                    queue.add(new int[] {i + 1, j});

                    if (grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        someThingChanged = true;
                    }
                }

                if (i > 0 && grid[i - 1][j] == 1 || i > 0 && grid[i][j] == 1) {
                    queue.add(new int[] {i - 1, j});

                    if (grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        someThingChanged = true;
                    }
                }

                if (j > 0 && grid[i][j - 1] == 1 || j > 0 && grid[i][j] == 1) {
                    queue.add(new int[] {i, j - 1});

                    if (grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                        someThingChanged = true;
                    }
                }

                queue.poll();
            }

            if (someThingChanged) {
                orangesRottingCount++;
            }
        }

        for (int[] i : grid) {
            for (int j : i) {
                if (j == 1) {
                    return -1;
                }
            }
        }

        return orangesRottingCount;
    }
}
