package designNeighborSumService;

import java.util.HashMap;
import java.util.Map;

public class NeighborSum {

    private final int[][] grid;
    private final Map<Integer, int[]> coords;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.coords = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.coords.put(grid[i][j], new int[] {i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] coords = this.coords.get(value);
        int sum = 0;
        if (coords[0] - 1 >= 0) {
            sum += this.grid[coords[0] - 1][coords[1]];
        }
        if (coords[0] + 1 < this.grid.length) {
            sum += this.grid[coords[0] + 1][coords[1]];
        }
        if (coords[1] - 1 >= 0) {
            sum += this.grid[coords[0]][coords[1] - 1];
        }
        if (coords[1] + 1 < this.grid[0].length) {
            sum += this.grid[coords[0]][coords[1] + 1];
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int[] coords = this.coords.get(value);
        int sum = 0;
        if (coords[0] - 1 >= 0) {
            if (coords[1] + 1 < this.grid[0].length) {
                sum += this.grid[coords[0] - 1][coords[1] + 1];
            }
            if (coords[1] - 1 >= 0) {
                sum += this.grid[coords[0] - 1][coords[1] - 1];
            }
        }
        if (coords[0] + 1 < this.grid.length) {
            if (coords[1] + 1 < this.grid[0].length) {
                sum += this.grid[coords[0] + 1][coords[1] + 1];
            }
            if (coords[1] - 1 >= 0) {
                sum += this.grid[coords[0] + 1][coords[1] - 1];
            }
        }
        return sum;
    }

}
