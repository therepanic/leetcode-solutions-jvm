package longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> high = new ArrayDeque<>();
        Deque<Integer> low = new ArrayDeque<>();

        int l = 0;

        int maxSize = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!high.isEmpty() && high.getLast() < nums[r]) {
                high.removeLast();
            }
            high.addLast(nums[r]);

            while (!low.isEmpty() && low.getLast() > nums[r]) {
                low.removeLast();
            }
            low.addLast(nums[r]);

            while (!high.isEmpty() && !low.isEmpty()
                    && high.getFirst() - low.getFirst() > limit) {
                if (nums[l] == high.getFirst()) {
                    high.removeFirst();
                } else if (nums[l] == low.getFirst()) {
                    low.removeFirst();
                }
                l++;
            }

            maxSize = Math.max(maxSize, r - l + 1);
        }

        return maxSize;
    }
}
