package finalPricesWithASpecialDiscountInAShop;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.getLast()[0] >= prices[i]) {
                prices[stack.getLast()[1]] -= prices[i];
                stack.removeLast();
            }

            stack.addLast(new int[] {prices[i], i});
        }

        return prices;
    }
}
