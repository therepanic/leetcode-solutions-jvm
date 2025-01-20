package minimumASCIIDeleteSumForTwoStrings;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
        //System.out.println(minimumDeleteSum("delete", "leet"));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + s2Chars[i - 1];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + s1Chars[i - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s2Chars[i - 1] == s1Chars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + s2Chars[i - 1], dp[i][j - 1] + s1Chars[j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
