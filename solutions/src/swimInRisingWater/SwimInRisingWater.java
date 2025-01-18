package swimInRisingWater;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        minHeap.add(new int[] {0, 0, grid[0][0]});

        int[] left = new int[] {1, -1, 0, 0};
        int[] up = new int[] {0, 0, 1, -1};

        boolean[][] checked = new boolean[grid.length][grid[0].length];

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();

            if (checked[poll[0]][poll[1]]) {
                continue;
            }

            if (poll[0] == grid.length - 1 && poll[1] == grid[0].length - 1) {
                return poll[2];
            }

            checked[poll[0]][poll[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + left[i];
                int y = poll[1] + up[i];

                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                    continue;
                }

                int point = Math.max(poll[2], grid[x][y]);

                minHeap.add(new int[] {x, y, point});
            }
        }
        return -1;
    }
}
