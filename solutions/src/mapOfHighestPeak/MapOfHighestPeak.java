package mapOfHighestPeak;

import java.util.ArrayDeque;
import java.util.Queue;

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] heights = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1;
                    queue.add(new int[] {newX, newY});
                }
            }
        }

        return heights;
    }
}
