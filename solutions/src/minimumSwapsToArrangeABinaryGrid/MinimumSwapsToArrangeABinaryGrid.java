package minimumSwapsToArrangeABinaryGrid;

public class MinimumSwapsToArrangeABinaryGrid {
    public int minSwaps(int[][] grid) {
        int[] suf = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int c = 0;
            for (int j = grid[i].length - 1; j >= 0 && grid[i][j] == 0; j--) {
                c++;
            }
            suf[i] = c;
        }
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            int p = grid[i].length - i - 1;
            int j = i;
            while (j < grid.length && suf[j] < p) {
                j++;
            }
            if (j == grid.length) {
                return -1;
            }
            c += j - i;
            int temp = suf[j];
            for (int k = j; k > i; k--) {
                suf[k] = suf[k - 1];
            }
            suf[i] = temp;
        }
        return c;
    }
}
