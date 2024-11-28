package minimumObstacleRemovalToReachCorner;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumObstacleRemovalToReachCorner {
    public static int minimumObstacles(int[][] grid) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[] {grid.length - 1, grid[0].length - 1, 0});

        int[] upWays = new int[] {1, -1, 0 ,0};
        int[] lWays = new int[] {0, 0, 1 ,-1};
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();

            if (poll[0] == 0 && poll[1] == 0) {
                return poll[2];
            }

            if (checked[poll[0]][poll[1]]) {
                continue;
            }

            checked[poll[0]][poll[1]] = true;

            for (int i = 0; i < 4; i++) {
                int newX = poll[0] + upWays[i];
                int newY = poll[1] + lWays[i];

                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    continue;
                }

                if (grid[newX][newY] == 0) {
                    deque.addFirst(new int[] {newX, newY, poll[2]});
                } else {
                    deque.addLast(new int[] {newX, newY, poll[2] + 1});
                }

            }
        }
        return -1;
    }
}
