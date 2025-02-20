package findKPairsWithSmallestSums;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> nums1[p[0]] + nums2[p[1]]));
        for (int i = 0; i < nums1.length; i++) {
            heap.add(new int[] {i, 0});
        }
        while (k-- > 0 && !heap.isEmpty()) {
            int[] poll = heap.poll();
            if (poll[1] >= nums2.length) continue;
            answer.add(List.of(nums1[poll[0]], nums2[poll[1]]));
            if (poll[1] + 1 >= nums2.length) continue;
            heap.add(new int[] {poll[0], poll[1] + 1});
        }
        return answer;
    }
}
