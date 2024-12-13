package findScoreOfAnArrayAfterMarkingAllElements;

import java.util.PriorityQueue;

public class FindScoreOfAnArrayAfterMarkingAllElements {
    public long findScore(int[] nums) {
        long score = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int equals = Integer.compare(nums[a], nums[b]);

            if (equals == 0) {
                return Integer.compare(a, b);
            } else {
                return equals;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(i);
        }

        boolean[] marked = new boolean[nums.length];

        while (!heap.isEmpty()) {
            int index = heap.poll();

            if (marked[index]) continue;

            score += nums[index];
            marked[index] = true;

            if (index - 1 >= 0) {
                marked[index - 1] = true;
            }
            if (index + 1 < nums.length) {
                marked[index + 1] = true;
            }
        }

        return score;
    }
}
