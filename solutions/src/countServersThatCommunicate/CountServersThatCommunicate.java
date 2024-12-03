package countServersThatCommunicate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] < 0 || poll[1] < 0 || poll[0] >= grid.length || poll[1] >= grid[0].length) {
                continue;
            }
            if (checked[poll[0]][poll[1]]) continue;

            boolean isOk = false;

            for (int i = poll[0] - 1; i >= 0; i--) {
                if (grid[i][poll[1]] == 1) isOk = true;
                if (checked[i][poll[1]]) break;

                if (grid[i][poll[1]] == 1) {
                    queue.add(new int[] {i, poll[1]});
                    break;
                }
            }

            for (int i = poll[0] + 1; i < grid.length; i++) {
                if (grid[i][poll[1]] == 1) isOk = true;
                if (checked[i][poll[1]]) break;

                if (grid[i][poll[1]] == 1) {
                    queue.add(new int[] {i, poll[1]});
                    isOk = true;
                    break;
                }
            }

            for (int i = poll[1] - 1; i >= 0; i--) {
                if (grid[poll[0]][i] == 1) isOk = true;
                if (checked[poll[0]][i]) break;

                if (grid[poll[0]][i] == 1) {
                    queue.add(new int[] {i, poll[1]});
                    isOk = true;
                    break;
                }
            }

            for (int i = poll[1] + 1; i < grid[0].length; i++) {
                if (grid[poll[0]][i] == 1) isOk = true;
                if (checked[poll[0]][i]) break;

                if (grid[poll[0]][i] == 1) {
                    queue.add(new int[] {i, poll[1]});
                    isOk = true;
                    break;
                }
            }

            if (isOk && grid[poll[0]][poll[1]] == 1) {
                checked[poll[0]][poll[1]] = true;
            }
        }
        int count = 0;

        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if (checked[i][j]) {
                    count++;
                }
            }
        }


        return count;
    }
}
