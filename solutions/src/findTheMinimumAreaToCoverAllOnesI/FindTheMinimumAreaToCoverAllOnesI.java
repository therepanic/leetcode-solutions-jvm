package findTheMinimumAreaToCoverAllOnesI;

public class FindTheMinimumAreaToCoverAllOnesI {
    public int minimumArea(int[][] grid) {
        int minI = Integer.MAX_VALUE;
        int maxI = 0;
        int minJ = Integer.MAX_VALUE;
        int maxJ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    minI = Math.min(minI, i);
                    minJ = Math.min(minJ, j);
                    maxI = Math.max(maxI, i);
                    maxJ = Math.max(maxJ, j);
                }
            }
        }
        return (maxI - minI + 1) * (maxJ - minJ + 1);
    }
}
