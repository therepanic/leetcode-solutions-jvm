package sumOfSubarrayMinimums;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[] {3,1,2,4}));
    }
    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
                deque.pollLast();
            }

            left[i] = deque.isEmpty() ? i + 1 : i - deque.getLast();

            deque.addLast(i);
        }
        deque.clear();

        for (int i = right.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
                deque.pollLast();
            }

            right[i] = deque.isEmpty() ? right.length - i : deque.getLast() - i;

            deque.addLast(i);
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * left[i] * right[i];
        }

        return sum;
    }
}
