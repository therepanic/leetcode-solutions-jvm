package dIStringMatch;

import java.util.ArrayDeque;
import java.util.Deque;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int[] nums = new int[s.length() + 1];
        int it = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= s.length(); i++) {
            stack.addLast(i);
            if (i == s.length() || s.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    nums[it] = stack.pollLast();
                    it++;
                }
            }
        }
        return nums;
    }
}
