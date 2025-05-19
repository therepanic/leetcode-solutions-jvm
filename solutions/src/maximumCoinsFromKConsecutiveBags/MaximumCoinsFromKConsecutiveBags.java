package maximumCoinsFromKConsecutiveBags;

import java.util.Arrays;

public class MaximumCoinsFromKConsecutiveBags {
    public static void main(String[] args) {
        System.out.println(maximumCoins(new int[][] {{8, 10, 1}, {1, 3, 2}, {5, 6, 4}}, 4));
    }
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
            //TODO
        }
        return answer;
    }
}
