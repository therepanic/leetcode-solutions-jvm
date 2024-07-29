package kthLargestElementInAnArray;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();
    }
}
