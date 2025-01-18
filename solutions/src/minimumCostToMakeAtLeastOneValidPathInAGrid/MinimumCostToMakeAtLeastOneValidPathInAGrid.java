package minimumCostToMakeAtLeastOneValidPathInAGrid;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    public static int minCost(int[][] grid) {
        Deque<int[]> minHeap = new ArrayDeque<>();
        minHeap.add(new int[] {0, 0, 0});

        boolean[][] checked = new boolean[grid.length][grid[0].length];

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.pollFirst();
            if (poll[0] < 0 || poll[1] < 0 || poll[0] >= grid.length || poll[1] >= grid[0].length || checked[poll[0]][poll[1]]) {
                continue;
            }
            if (poll[0] == grid.length - 1 && poll[1] == grid[0].length - 1) {
                return poll[2];
            }

            checked[poll[0]][poll[1]] = true;

            boolean right = false;
            boolean left = false;
            boolean bottom = false;
            boolean upper = false;

            int val = grid[poll[0]][poll[1]];

            if (val == 1) {
                right = true;

                minHeap.addFirst(new int[] {poll[0], poll[1] + 1, poll[2]});
            } else if (val == 2) {
                left = true;

                minHeap.addFirst(new int[] {poll[0], poll[1] - 1, poll[2]});
            } else if (val == 3) {
                bottom = true;

                minHeap.addFirst(new int[] {poll[0] + 1, poll[1], poll[2]});
            } else if (val == 4) {
                upper = true;

                minHeap.addFirst(new int[] {poll[0] - 1, poll[1], poll[2]});
            }

            if (!right) {
                minHeap.addLast(new int[] {poll[0], poll[1] + 1, poll[2] + 1});
            }
            if (!left) {
                minHeap.addLast(new int[] {poll[0], poll[1] - 1, poll[2] + 1});
            }
            if (!bottom) {
                minHeap.addLast(new int[] {poll[0] + 1, poll[1], poll[2] + 1});
            }
            if (!upper) {
                minHeap.addLast(new int[] {poll[0] - 1, poll[1], poll[2] + 1});
            }
        }

        return -1;
    }
}
