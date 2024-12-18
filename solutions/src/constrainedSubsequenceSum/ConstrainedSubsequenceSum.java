package constrainedSubsequenceSum;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && i - deque.getFirst() > k) {
                deque.removeFirst();
            }

            dp[i] = (deque.isEmpty() ? 0 : dp[deque.getFirst()]) + nums[i];

            while (!deque.isEmpty() && dp[i] > dp[deque.getLast()]) {
                deque.removeLast();
            }

            if (dp[i] > 0) deque.addLast(i);
        }

        int max = Integer.MIN_VALUE;

        for (int num : dp) max = Math.max(max, num);
        return max;
    }
}
