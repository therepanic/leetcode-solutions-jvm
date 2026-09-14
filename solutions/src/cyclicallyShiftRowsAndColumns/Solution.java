class Solution {
    public int[][] cyclicShift(int A, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < grid.length; i++) {
            int shift = rowShift[i];
            int[] n = new int[grid[0].length];
            for (int j = 0; j < grid[i].length; j++) {
                n[j] = grid[i][(j + shift) % grid[i].length];
            }
            grid[i] = n;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int shift = colShift[i];
            int[] n = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                n[j] = grid[(j + shift) % grid[i].length][i];
            }
            for (int j = 0; j < grid.length; j++) {
                grid[j][i] = n[j];
            }
        }
        return grid;
    }
}
