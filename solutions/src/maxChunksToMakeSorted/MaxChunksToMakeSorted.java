package maxChunksToMakeSorted;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.getLast() <= num) {
                stack.addLast(num);
            } else {
                int last = stack.pollLast();

                while (!stack.isEmpty() && stack.getLast() > num) {
                    stack.removeLast();
                }

                stack.addLast(last);
            }
        }

        return stack.size();
    }
}
