package minimumDeletionsToMakeArrayBeautiful;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MinimumDeletionsToMakeArrayBeautiful {
    public static int minDeletion(int[] nums) {
        int c = 0;
        boolean signal = true;
        Deque<Integer> stack = new ArrayDeque<>(List.of(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && signal && stack.getLast().equals(nums[i])) {
                c++;
            } else {
                signal = !signal;
                stack.addLast(nums[i]);
            }
        }
        if (stack.size() % 2 != 0) {
            c++;
        }
        return c;
    }
}
