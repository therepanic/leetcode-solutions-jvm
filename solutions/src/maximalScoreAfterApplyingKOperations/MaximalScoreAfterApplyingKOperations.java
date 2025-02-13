package maximalScoreAfterApplyingKOperations;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public static long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add((long) num);
        }
        while (k != 0 && !heap.isEmpty()) {
            long poll = heap.poll();
            score += poll;
            heap.add((poll + 2) / 3);
            k--;
            if (poll == 1) {
                score += k;
                break;
            }
        }
        return score;
    }
}
