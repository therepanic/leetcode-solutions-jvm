package maxChunksToMakeSortedII;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : arr) {
            if (!stack.isEmpty() && stack.getLast() > num) {
                int max = stack.getLast();

                while (!stack.isEmpty() && stack.getLast() > num) {
                    stack.removeLast();
                }

                stack.addLast(max);
                continue;
            }

            stack.addLast(num);
        }

        return stack.size();
    }
}
