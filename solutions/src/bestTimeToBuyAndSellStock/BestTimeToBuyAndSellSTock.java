package bestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellSTock {
    public static int maxProfit(int[] prices) {
        int toBuy = Integer.MAX_VALUE;
        int toSell;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < toBuy) {
                toBuy = price;

                toSell = 0;
            } else {
                toSell = price;
            }

            maxProfit = Math.max(maxProfit, toSell - toBuy);
        }

        return maxProfit;
    }
}
