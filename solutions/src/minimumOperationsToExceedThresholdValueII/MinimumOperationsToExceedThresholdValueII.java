package minimumOperationsToExceedThresholdValueII;

import java.util.*;

public class MinimumOperationsToExceedThresholdValueII {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) heap.add((long) num);
        }
        int c = 0;
        while (heap.size() >= 2) {
            long first = heap.poll() * 2;
            long second = heap.poll();
            long sum = first + second;
            if (sum < k) heap.add(sum);
            c++;
        }
        if (!heap.isEmpty() && heap.peek() < k) c++;
        return c;
    }
}
