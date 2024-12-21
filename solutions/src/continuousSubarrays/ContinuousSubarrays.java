package continuousSubarrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        long count = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!minDeque.isEmpty() && nums[minDeque.getLast()] >= nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(r);

            while (!maxDeque.isEmpty() && nums[maxDeque.getLast()] <= nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(r);

            while (nums[maxDeque.getFirst()] - nums[minDeque.getFirst()] > 2) {
                if (minDeque.getFirst() == l) {
                    minDeque.removeFirst();
                }

                if (maxDeque.getFirst() == l) {
                    maxDeque.removeFirst();
                }

                l++;
            }

            count += r- l + 1;
        }

        return count;
    }
}
