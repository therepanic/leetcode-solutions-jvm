package minimumOperationsToConvertAllElementsToZero;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumOperationsToConvertAllElementsToZero {
    public static int minOperations(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                c += stack.size();
                stack.clear();
                continue;
            }
            while (!stack.isEmpty() && stack.getLast()[0] > nums[i]) {
                stack.pollLast();
                c++;
            }
            int k = 1;
            if (!stack.isEmpty() && stack.getLast()[0] == nums[i]) {
                k += stack.getLast()[1];
                stack.pollLast();
            }
            stack.addLast(new int[] {nums[i], k});
        }
        c += stack.size();
        stack.clear();
        return c;
    }
}
