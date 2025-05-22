package zeroArrayTransformationIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {
    public int maxRemoval(int[] nums, int[][] queries) {
        int it = 0;
        int count = 0;
        Arrays.sort(queries, Comparator.comparingInt(p -> p[0]));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            while (it < queries.length && queries[it][0] == i) {
                max.add(queries[it][1]);
                it++;
            }
            while (!min.isEmpty() && min.peek() < i) {
                min.poll();
            }
            while (nums[i] > min.size()) {
                if (max.isEmpty() || max.peek() < i) {
                    return -1;
                } else {
                    min.add(max.poll());
                    count++;
                }
            }
        }
        return queries.length - count;
    }
}
