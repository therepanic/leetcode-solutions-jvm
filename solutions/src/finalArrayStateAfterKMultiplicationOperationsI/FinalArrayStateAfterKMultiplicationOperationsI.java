package finalArrayStateAfterKMultiplicationOperationsI;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int result = Integer.compare(a[0], b[0]);

            if (result == 0) {
                return Integer.compare(a[1], b[1]);
            } else {
                return result;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(new int[] {nums[i], i});
        }

        while (k > 0) {
            int[] poll = heap.poll();

            poll[0] *= multiplier;

            heap.add(poll);

            nums[poll[1]] = poll[0];

            k--;
        }

        return nums;
    }
}
