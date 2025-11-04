package maximumNumberOfConsecutiveValuesYouCanMake;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        int r = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin <= r + 1) {
                r += coin;
            } else {
                return r + 1;
            }
        }
        return r + 1;
    }
}
