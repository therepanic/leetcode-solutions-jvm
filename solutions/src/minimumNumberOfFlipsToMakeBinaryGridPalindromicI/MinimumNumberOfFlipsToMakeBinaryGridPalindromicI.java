package minimumNumberOfFlipsToMakeBinaryGridPalindromicI;

public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicI {
    public int minFlips(int[][] grid) {
        int rowCount = 0;
        int columnCount = 0;

        for (int[] area : grid) {
            rowCount += isPalindromicRow(area);
        }

        for (int j = 0; j < grid[0].length; j++) {
            columnCount += isPalindromicColumn(grid, j);
        }

        return Math.min(rowCount, columnCount);
    }

    public int isPalindromicRow(int[] area) {
        int count = 0;

        for (int i = 0; i < area.length / 2; i++) {
            if (area[i] != area[area.length - i - 1]) {
                count++;
            }
        }

        return count;
    }

    public int isPalindromicColumn(int[][] grid, int j) {
        int count = 0;

        for (int i = 0; i < grid.length / 2; i++) {
            if (grid[i][j] != grid[grid.length - i - 1][j]) {
                count++;
            }
        }

        return count;
    }
}
