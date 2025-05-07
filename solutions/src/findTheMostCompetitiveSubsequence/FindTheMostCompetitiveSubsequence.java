package findTheMostCompetitiveSubsequence;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && deq.getLast() > nums[i] && nums.length - i + deq.size() > k) {
                deq.pollLast();
            }
            if (deq.size() < k) {
                deq.addLast(nums[i]);
            }
        }
        int[] mostCompetitive = new int[k];
        int it = 0;
        for (int val : deq) {
            mostCompetitive[it] = val;
            it++;
        }
        return mostCompetitive;
    }
}
