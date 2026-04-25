package mergeAdjacentEqualElements;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            long a = nums[i];
            while (!stack.isEmpty() && stack.getLast().equals(a)) {
                stack.pollLast();
                long d = a * 2;
                a = d;
            }
            stack.addLast(a);
        }
        return stack.stream().toList();
    }
}
