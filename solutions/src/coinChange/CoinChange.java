package coinChange;

import java.util.Arrays;
import java.util.Map;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[amount];
    }
}
