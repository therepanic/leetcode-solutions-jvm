package maximumProductAfterKIncrements;

import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        while (k != 0) {
            minHeap.add(minHeap.poll() + 1);
            k--;
        }
        long product = minHeap.poll();
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % 1_000_000_007;
        }
        return (int) product;
    }
}
