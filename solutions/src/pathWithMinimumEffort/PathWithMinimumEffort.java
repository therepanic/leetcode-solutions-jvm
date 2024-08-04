package pathWithMinimumEffort;

import java.util.*;

public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int[][] newHeights = new int[heights.length][heights[0].length];
        for (int[] height : newHeights) {
            Arrays.fill(height, Integer.MAX_VALUE);
        }

        newHeights[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        queue.add(new int[] {0, 0, Integer.MIN_VALUE});

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();

            if (pair[0] > 0) {
                int max = Math.max(pair[2], Math.abs(heights[pair[0]][pair[1]] - heights[pair[0] - 1][pair[1]]));

                if (max < newHeights[pair[0] - 1][pair[1]]) {
                    newHeights[pair[0] - 1][pair[1]] = max;

                    queue.add(new int[] {pair[0] - 1, pair[1], max});
                }
            }

            if (pair[1] > 0) {
                int max = Math.max(pair[2], Math.abs(heights[pair[0]][pair[1]] - heights[pair[0]][pair[1] - 1]));

                if (max < newHeights[pair[0]][pair[1] - 1]) {
                    newHeights[pair[0]][pair[1] - 1] = max;

                    queue.add(new int[] {pair[0], pair[1] - 1, max});
                }
            }

            if (pair[0] < heights.length - 1) {
                int max = Math.max(pair[2], Math.abs(heights[pair[0]][pair[1]] - heights[pair[0] + 1][pair[1]]));

                if (max < newHeights[pair[0] + 1][pair[1]]) {
                    newHeights[pair[0] + 1][pair[1]] = max;

                    queue.add(new int[] {pair[0] + 1, pair[1], max});
                }
            }

            if (pair[1] < heights[0].length - 1) {
                int max = Math.max(pair[2], Math.abs(heights[pair[0]][pair[1]] - heights[pair[0]][pair[1] + 1]));

                if (max < newHeights[pair[0]][pair[1] + 1]) {
                    newHeights[pair[0]][pair[1] + 1] = max;

                    queue.add(new int[] {pair[0], pair[1] + 1, max});
                }
            }
        }

        return newHeights[newHeights.length - 1][newHeights[0].length - 1];
    }
}
