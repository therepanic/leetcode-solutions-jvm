package maximumRowsCoveredByColumns;

public class MaximumRowsCoveredByColumns {
    public int maximumRows(int[][] matrix, int numSelect) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] |= (1 << j);
                }
            }
        }
        int ans = 0;
        int p = 1 << m;
        for (int mask = 0; mask < p; mask++) {
            int c = 0;
            if (Integer.bitCount(mask) != numSelect) continue;
            for (int i = 0; i < n; i++) {
                if ((rows[i] & mask) == rows[i]) {
                    c++;
                }
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
