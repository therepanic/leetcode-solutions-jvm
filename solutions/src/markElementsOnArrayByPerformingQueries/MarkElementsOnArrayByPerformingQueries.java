package markElementsOnArrayByPerformingQueries;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MarkElementsOnArrayByPerformingQueries {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] answer = new long[queries.length];
        Set<Integer> toDelete = new HashSet<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            heap.add(new int[] {nums[i], i});
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (!toDelete.contains(query[0])) {
                toDelete.add(query[0]);
                sum -= nums[query[0]];
            }
            for (int k = 0; k < query[1] && !heap.isEmpty(); k++) {
                while (!heap.isEmpty() && toDelete.contains(heap.peek()[1])) {
                    heap.poll();
                }
                if (heap.isEmpty()) break;
                int[] poll = heap.poll();
                sum -= poll[0];
                toDelete.add(poll[1]);
            }
            answer[i] = sum;
        }
        return answer;
    }

}
