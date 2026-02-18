package countBowlSubarrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountBowlSubarrays {
    public long bowlSubarrays(int[] nums) {
        long ans = 0;
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && nums[i] > deq.getLast()) {
                deq.pollLast();
                if (!deq.isEmpty()) {
                    ans++;
                }
            }
            deq.addLast(nums[i]);
        }
        return ans;
    }
}
