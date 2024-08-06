package numberOfEnclaves;

import java.util.*;

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        boolean[][] notEnclave = new boolean[grid.length][grid[0].length];

        Queue<int[]> islandQueue = new ArrayDeque<>();

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                islandQueue.add(new int[] {0, i});
            }

            if (grid.length - 1 != 0 && grid[grid.length - 1][i] == 1) {
                islandQueue.add(new int[] {grid.length - 1, i});
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                islandQueue.add(new int[] {i, 0});
            }

            if (grid[i][grid[0].length - 1] == 1) {
                islandQueue.add(new int[] {i, grid[0].length - 1});
            }
        }

        Set<String> checked = new HashSet<>();
        while (!islandQueue.isEmpty()) {
            int[] pair = islandQueue.poll();

            if (pair[0] < 0 || pair[1] < 0 || pair[0] >= grid.length || pair[1] >= grid[0].length || checked.contains(pair[0] + " " + pair[1]) || grid[pair[0]][pair[1]] == 0) {
                continue;
            }

            checked.add(pair[0] + " " + pair[1]);

            notEnclave[pair[0]][pair[1]] = true;

            islandQueue.add(new int[] {pair[0] + 1, pair[1]});
            islandQueue.add(new int[] {pair[0] - 1, pair[1]});
            islandQueue.add(new int[] {pair[0], pair[1] - 1});
            islandQueue.add(new int[] {pair[0], pair[1] + 1});
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !notEnclave[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
