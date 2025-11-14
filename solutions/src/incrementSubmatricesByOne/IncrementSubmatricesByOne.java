package incrementSubmatricesByOne;

public class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] differ = new int[n + 1][n + 1];
        for (int[] query : queries) {
            differ[query[0]][query[1]] += 1;
            differ[query[0]][query[3] + 1] -= 1;
            differ[query[2] + 1][query[1]] -= 1;
            differ[query[2] + 1][query[3] + 1] += 1;
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = differ[i][j];
                if (i > 0) {
                    val += ans[i - 1][j];
                }
                if (j > 0) {
                    val += ans[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    val -= ans[i - 1][j - 1];
                }
                ans[i][j] = val;
            }
        }
        return ans;
    }
}
