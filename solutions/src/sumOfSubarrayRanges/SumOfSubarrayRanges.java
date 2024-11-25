package sumOfSubarrayRanges;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[] {4,-2,-3,4,1}));
    }
    public static long subArrayRanges(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] leftSmall = new int[nums.length];
        int[] rightSmall = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] > nums[i]) {
                deque.pollLast();
            }

            leftSmall[i] = deque.isEmpty() ? i + 1 : i - deque.getLast();

            deque.addLast(i);
        }

        deque.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.getLast()] >= nums[i]) {
                deque.pollLast();
            }

            rightSmall[i] = deque.isEmpty() ? rightSmall.length - i: deque.getLast() - i;

            deque.addLast(i);
        }
        deque.clear();

        int[] leftBig = new int[nums.length];
        int[] rightBig = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }

            leftBig[i] = deque.isEmpty() ? i + 1 : i - deque.getLast();

            deque.addLast(i);
        }

        deque.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }

            rightBig[i] = deque.isEmpty() ? rightBig.length - i: deque.getLast() - i;

            deque.addLast(i);
        }

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += ((long) nums[i] * leftSmall[i] * rightSmall[i]) - ((long) nums[i] * leftBig[i] * rightBig[i]);
        }

        return -sum;
    }
}
