package maximumNumberOfPointsFromGridQueries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfPointsFromGridQueries {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(p -> p[0]));
        heap.add(new int[] {grid[0][0], 0, 0});
        int points = 0;
        int[] answer = new int[queries.length];
        visited[0][0] = true;
        for (int[] q : sortedQueries) {
            while (!heap.isEmpty() && heap.peek()[0] < q[0]) {
                int[] poll = heap.poll();
                points++;
                for (int[] d : dir) {
                    int x = d[0] + poll[1];
                    int y = d[1] + poll[2];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
                        heap.add(new int[] {grid[x][y], x, y});
                        visited[x][y] = true;
                    }
                }
            }
            answer[q[1]] = points;
        }
        return answer;
    }
}
