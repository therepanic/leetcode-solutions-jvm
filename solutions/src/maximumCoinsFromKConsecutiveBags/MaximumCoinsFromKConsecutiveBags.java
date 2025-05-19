package maximumCoinsFromKConsecutiveBags;

import java.util.Arrays;

public class MaximumCoinsFromKConsecutiveBags {
    public static long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        long answer = 0;
        long c = 0;
        int it = 0;
        for (int i = 0; i < coins.length; i++) {
            int start = coins[i][0];
            int end = start + k - 1;
            while (it < coins.length && end >= coins[it][1]) {
                c += ((coins[it][1] - (long) coins[it][0] + 1) * coins[it][2]);
                it++;
            }
            if (it < coins.length) {
                answer = Math.max(answer, c + Math.max(0, ((long) end - coins[it][0] + 1)) * coins[it][2]);
            }
            c -= (coins[i][1] - coins[i][0] + 1) * (long) coins[i][2];
        }
        c = 0;
        it = 0;
        for (int i = 0; i < coins.length; i++) {
            int end = coins[i][1];
            int start = end - k + 1;
            c += ((long) (coins[i][1] - coins[i][0] + 1) * coins[i][2]);
            while (it < coins.length && start > coins[it][1]) {
                c -= ((coins[it][1] - (long) coins[it][0] + 1) * coins[it][2]);
                it++;
            }
            if (it < coins.length) {
                answer = Math.max(answer, c - Math.max(0, ((long) start - coins[it][0])) * coins[it][2]);
            }
        }
        return answer;
    }
}
