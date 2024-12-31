package findKClosestElements;

import java.util.*;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> nums = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((p1, p2) -> {
            int res1 = Math.abs(x - p1);
            int res2 = Math.abs(x - p2);

            if (res1 == res2) {
                return Integer.compare(p1, p2);
            } else {
                return Integer.compare(res1, res2);
            }
        });

        for (int num : arr) {
            heap.add(num);
        }

        for (int i = 0; i < k; i++) {
            nums.add(heap.poll());
        }

        Collections.sort(nums);

        return nums;
    }
}
