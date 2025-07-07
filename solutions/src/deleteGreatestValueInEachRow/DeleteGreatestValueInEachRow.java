package deleteGreatestValueInEachRow;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int c = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int val = 0;
            for (int j = 0; j < grid.length; j++) {
                val = Math.max(val, grid[j][i]);
            }
            c += val;
        }
        return c;
    }

}
