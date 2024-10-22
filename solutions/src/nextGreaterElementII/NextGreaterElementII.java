package nextGreaterElementII;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newNums = new int[nums.length];
        Arrays.fill(newNums, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                newNums[stack.pollLast()] = nums[i];
            }

            stack.addLast(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                newNums[stack.pollLast()] = nums[i];
            }

            stack.addLast(i);
        }

        return newNums;
    }
}
