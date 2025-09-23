package rearrangeArrayToMaximizePrefixScore;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RearrangeArrayToMaximizePrefixScore {
    public int maxScore(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(nums);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            sum += num;
            minHeap.add(num);
            while (sum <= 0 && !minHeap.isEmpty()) {
                sum -= minHeap.poll();
            }
        }
        return minHeap.size();
    }
}
