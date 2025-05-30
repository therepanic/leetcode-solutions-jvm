package minimumPathCostInAGrid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPathCostInAGrid {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dir = new int[][] {{1, 0}, {1, 1}, {1, -1}};
        PriorityQueue<int[]> score = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        for (int i = 0; i < grid[0].length; i++) {
            score.add(new int[] {0, i, grid[0][i]});
        }
        int[][] checked = new int[grid.length][grid[0].length];
        for (int[] c : checked) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        while (!score.isEmpty()) {
            int[] poll = score.poll();
            if (poll[0] == grid.length - 1) {
                return poll[2];
            }
            if (checked[poll[0]][poll[1]] < poll[2]) {
                continue;
            }
            checked[poll[0]][poll[1]] = poll[2];
            for (int y = -grid[0].length; y <= grid[0].length; y++) {
                int x = poll[0] + 1;
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || checked[x][y] < poll[2]) {
                    continue;
                }
                int s = poll[2] + grid[x][y] + moveCost[grid[poll[0]][poll[1]]][y];
                score.add(new int[] {x, y, s});
            }
        }
        return -1;
    }

}
