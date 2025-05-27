package findTheSafestPathInAGrid;

import java.util.*;

public class FindTheSafestPathInAGrid {
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] minForThieve = new int[grid.size()][grid.get(0).size()];
        for (int[] arr : minForThieve) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    minForThieve[i][j] = 0;
                    queue.add(new int[] {i, j, 0});
                }
            }
        }
        int[][] dir = new int[][] {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                if (x >= 0 && y >= 0 && x < grid.size() && y < grid.get(0).size() && (minForThieve[x][y] > poll[2] + 1)) {
                    minForThieve[x][y] = poll[2] + 1;
                    queue.add(new int[] {x, y, poll[2] + 1});
                }
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[2], p1[2]));
        heap.add(new int[] {0, 0, minForThieve[0][0]});
        int[][] visited = new int[grid.size()][grid.get(0).size()];
        for (int[] row : visited) Arrays.fill(row, -1);
        visited[0][0] = minForThieve[0][0];
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (poll[2] < visited[poll[0]][poll[1]]) {
                continue;
            }
            if (poll[0] == grid.size() -1 && poll[1] == grid.get(0).size() - 1) {
                return poll[2];
            }
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                if (x >= 0 && y >= 0 && x < grid.size() && y < grid.get(0).size() && visited[x][y] < Math.min(minForThieve[x][y], poll[2])) {
                    visited[x][y] = Math.min(minForThieve[x][y], poll[2]);
                    heap.add(new int[] {x, y, Math.min(minForThieve[x][y], poll[2])});
                }
            }
        }
        return 0;
    }

}
