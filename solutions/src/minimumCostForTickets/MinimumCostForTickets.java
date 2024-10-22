package minimumCostForTickets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<>();

        for (int day : days) {
            daysSet.add(day);
        }

        int maxDay = days[days.length - 1];

        int[] dp = new int[maxDay + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (!daysSet.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i], Math.min(dp[i - 1] + costs[0], dp[Math.max(i - 7, 0)] + costs[1]));
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
            }
        }

        return dp[maxDay];
    }
}
