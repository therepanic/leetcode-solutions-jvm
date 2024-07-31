package slidingWindowMaximum;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int[] maxSlidingWindow = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int j = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 > k) {
                if (!deque.isEmpty() && deque.peekFirst().equals(nums[l])) {
                    deque.removeFirst();
                }

                l++;
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[r]) {
                deque.removeLast();
            }

            deque.addLast(nums[r]);

            if (r - l + 1 >= k) {
                maxSlidingWindow[j] = deque.getFirst();
                j++;
            }
        }

        return maxSlidingWindow;
    }
}
