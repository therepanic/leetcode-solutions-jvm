package onlineStockSpan;

import java.util.ArrayDeque;
import java.util.Deque;


public class StockSpanner {
    private final Deque<int[]> stack;
    private int count = 1;
    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;

        while (!stack.isEmpty() && stack.getLast()[0] <= price) {
            count += stack.pollLast()[1];
        }

        stack.addLast(new int[] {price, count});

        return count;
    }
}
