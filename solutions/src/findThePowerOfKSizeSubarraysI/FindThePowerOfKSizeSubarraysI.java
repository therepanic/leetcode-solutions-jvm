package findThePowerOfKSizeSubarraysI;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindThePowerOfKSizeSubarraysI {
    public static int[] resultsArray(int[] nums, int k) {
        int l = 0;
        Deque<Integer> deq = new ArrayDeque<>();
        int c = 0;
        int[] answer = new int[nums.length - k + 1];
        int it = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 > k) {
                if (!deq.isEmpty() && deq.getFirst().equals(nums[l])) {
                    deq.pollFirst();
                }
                l++;
            }
            while (!deq.isEmpty() && deq.getLast() < nums[r]) {
                deq.pollLast();
            }
            deq.addLast(nums[r]);
            if (r != 0 && nums[r - 1] + 1 != nums[r]) {
                c = k - 1;
            }
            if (r - l + 1 == k) {
                if (c == 0) {
                    answer[it] = deq.getFirst();
                } else {
                    answer[it] = -1;
                }
                it++;
            }
            if (c != 0) {
                c--;
            }
        }
        return answer;
    }
}
