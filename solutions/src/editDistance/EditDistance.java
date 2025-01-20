package editDistance;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1Chars[i - 1] == word2Chars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int c = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                dp[i][j] = c;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
