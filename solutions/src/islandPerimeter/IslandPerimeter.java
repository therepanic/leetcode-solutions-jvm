package islandPerimeter;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        Queue<int[]> bfs = new ArrayDeque<>();
        first: for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    bfs.add(new int[] {i, j});
                    break first;
                }
            }
        }
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int perimeter = 0;
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            grid[poll[0]][poll[1]] = -1;
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                    perimeter++;
                    continue;
                }
                if (grid[x][y] == -1) {
                    continue;
                }
                grid[x][y] = -1;
                bfs.add(new int[] {x, y});
            }
        }
        return perimeter;
    }

}
