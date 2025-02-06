package maximumWidthRamp;

import java.util.*;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> monotonic = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (monotonic.isEmpty() || nums[i] < nums[monotonic.getLast()]) {
                monotonic.addLast(i);
            }
        }
        int maxWidth = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!monotonic.isEmpty() && nums[monotonic.getLast()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - monotonic.pollLast());
            }
        }
        return maxWidth;
    }
}
