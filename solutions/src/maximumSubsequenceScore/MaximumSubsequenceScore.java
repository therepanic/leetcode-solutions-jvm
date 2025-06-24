package maximumSubsequenceScore;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] values = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            values[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(values, (p1, p2) -> p2[1] - p1[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        long sum = 0;
        long answer = 0;
        for (int[] val : values) {
            sum += val[0];
            heap.add(val[0]);
            if (heap.size() > k) {
                sum -= heap.poll();
            }
            if (heap.size() == k) {
                answer = Math.max(answer, sum * val[1]);
            }
        }
        return answer;
    }

}
