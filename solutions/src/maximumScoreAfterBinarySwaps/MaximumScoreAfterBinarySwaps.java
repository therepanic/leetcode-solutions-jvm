package maximumScoreAfterBinarySwaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumScoreAfterBinarySwaps {
    public long maximumScore(int[] nums, String s) {
        long score = 0;
        PriorityQueue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            values.add(nums[i]);
            if (s.charAt(i) == '1') {
                score += values.poll();
            }
        }
        return score;
    }
}
