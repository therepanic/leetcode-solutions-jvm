package uniqueBinarySearchTrees;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int s = 0;

            for (int root = 1; root <= i; root++) {
                int left = root - 1;
                int right = i - root;

                s += dp[left] * dp[right];
            }

            dp[i] = s;
        }

        return dp[n];
    }
}
