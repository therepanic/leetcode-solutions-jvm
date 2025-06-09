package kHighestRankedItemsWithinAPriceRange;

import java.util.*;

public class KHighestRankedItemsWithinAPriceRange {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> best = new ArrayList<>();
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[] {start[0], start[1], grid[start[0]][start[1]]});
        grid[start[0]][start[1]] = 0;
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!bfs.isEmpty() && best.size() < k) {
            int size = bfs.size();
            List<List<Integer>> bestTemp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] poll = bfs.poll();
                int x = poll[0], y = poll[1];
                if (poll[2] > 1 && pricing[0] <= poll[2] && pricing[1] >= poll[2]) {
                    bestTemp.add(List.of(x, y, poll[2]));
                }
                for (int[] d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0) {
                        continue;
                    }
                    bfs.add(new int[] {newX, newY, grid[newX][newY]});
                    grid[newX][newY] = 0;
                }
            }
            Collections.sort(bestTemp, (p1, p2) -> {
                if (!p1.get(2).equals(p2.get(2))) {
                    return Integer.compare(p1.get(2), p2.get(2));
                } else if (!p1.get(0).equals(p2.get(0))) {
                    return Integer.compare(p1.get(0), p2.get(0));
                } else {
                    return Integer.compare(p1.get(1), p2.get(1));
                }
            });
            for (int i = 0; i < bestTemp.size() && best.size() < k; i++) {
                List<Integer> val = bestTemp.get(i);
                best.add(List.of(val.get(0), val.get(1)));
            }
        }
        return best;
    }
}
