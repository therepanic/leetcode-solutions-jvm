package maximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][];

        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2];

        for (int i = 1; i < dp.length; i++) {
            int p = bypass(jobs, i);

            dp[i] = Math.max(dp[i - 1], jobs[i][2] + (p == -1 ? 0 : dp[p]));
        }

        return dp[jobs.length - 1];
    }

    public int bypass(int[][] jobs, int i) {
        int l = 0;
        int r = i - 1;

        while (l <= r) {
            int mid = (r + l) / 2;

            if (jobs[mid][1] <= jobs[i][0]) {
                l = mid + 1;
            } else if (jobs[mid][1] > jobs[i][0]){
                r = mid - 1;
            }
        }

        return r;
    }
}
