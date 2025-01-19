package dungeonGame;

import java.util.Arrays;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dp[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1, 1 - dungeon[dungeon.length - 1][dungeon[0].length - 1]);

        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) continue;

                if (i < dungeon.length - 1) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i + 1][j] - dungeon[i][j]));
                }
                if (j < dungeon[0].length - 1) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i][j + 1] - dungeon[i][j]));
                }
            }
        }
        return dp[0][0];
    }
}
