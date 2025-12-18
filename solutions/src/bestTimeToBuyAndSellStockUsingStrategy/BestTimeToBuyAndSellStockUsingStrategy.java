package bestTimeToBuyAndSellStockUsingStrategy;

public class BestTimeToBuyAndSellStockUsingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int half = k / 2;
        long base = 0;
        long[] prefLose = new long[n + 1];
        long[] prefGain = new long[n + 1];
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
            prefLose[i + 1] = prefLose[i] + (long) (-strategy[i]) * prices[i];
            prefGain[i + 1] = prefGain[i] + (long) (1 - strategy[i]) * prices[i];
        }
        long bestDelta = 0;
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;
            long left = prefLose[mid] - prefLose[l];
            long right = prefGain[r] - prefGain[mid];
            long delta = left + right;
            bestDelta = Math.max(bestDelta, delta);
        }
        return base + bestDelta;
    }

}
