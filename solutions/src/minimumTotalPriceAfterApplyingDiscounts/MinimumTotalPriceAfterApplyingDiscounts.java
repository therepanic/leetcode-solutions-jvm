package minimumTotalPriceAfterApplyingDiscounts;

import java.util.Arrays;

public class MinimumTotalPriceAfterApplyingDiscounts {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double answer = 0;
        int j = discounts.length - 1;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (j >= 0) {
                answer += (double) prices[i] * (100 - discounts[j]) / 100;
                j--;
            } else {
                answer += prices[i];
            }
        }
        return answer;
    }
}
