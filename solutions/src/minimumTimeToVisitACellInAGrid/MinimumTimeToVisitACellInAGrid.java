package minimumTimeToVisitACellInAGrid;

import java.util.*;

public class MinimumTimeToVisitACellInAGrid {
    public static int minimumTime(int[][] grid) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));

        heap.add(new int[] {0, 0, 0});

        int[] upMoves = new int[] {1, -1, 0, 0};
        int[] leftMoves = new int[] {0, 0, 1, -1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();

            if (visited[poll[0]][poll[1]]) {
                continue;
            }

            visited[poll[0]][poll[1]] = true;

            if (poll[0] == grid.length - 1 && poll[1] == grid[0].length - 1) {
                return poll[2];
            }

            for (int k = 0; k < 4; k++) {
                int newX = poll[0] + upMoves[k];
                int newY = poll[1] + leftMoves[k];

                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    continue;
                }

                int f = (grid[newX][newY] - poll[2]) % 2 == 0 ? 1 : 0;

                heap.add(new int[] {newX, newY, Math.max(grid[newX][newY] + f, poll[2] + 1)});
            }
        }

        return -1;
    }
}
