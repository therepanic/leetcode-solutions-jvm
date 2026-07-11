package maximumNumberOfCoinsYouCanGet;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        int sum = 0;
        int n = piles.length;
        Arrays.sort(piles);
        for (int i = n / 3; i < n; i += 2) {
            sum += piles[i];
        }
        return sum;
    }
}
