package bestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }
        minPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            minPrice = Math.max(minPrice, prices[i]);
            right[i] = Math.max(right[i + 1], minPrice - prices[i]);
        }
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum = Math.max(sum, left[i] + right[i]);
        }
        return sum;
    }
}
