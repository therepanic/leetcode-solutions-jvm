package findSubsequenceOfLengthKWithTheLargestSum;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithTheLargestSum {

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        for (int i = 0; i < nums.length; i++) {
            heap.add(new int[] {nums[i], i});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        PriorityQueue<int[]> heap2 = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        heap2.addAll(heap);
        int[] ans2 = new int[k];
        for (int i = 0; i < k; i++) {
            ans2[i] = heap2.poll()[0];
        }
        return ans2;
    }

}
