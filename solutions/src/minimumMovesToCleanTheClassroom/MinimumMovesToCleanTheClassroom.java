package minimumMovesToCleanTheClassroom;

import java.util.*;

public class MinimumMovesToCleanTheClassroom {

    public static int minMoves(String[] classroom, int energy) {
        char[][] grid = new char[classroom.length][classroom[0].length()];
        Queue<int[]> bfs = new ArrayDeque<>();
        Map<String, Integer> maskMap = new HashMap<>();
        int litterCount = 0;
        int maskC = 0;
        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length(); j++) {
                grid[i][j] = classroom[i].charAt(j);
                if (grid[i][j] == 'S') {
                    bfs.add(new int[] {i, j, 0, energy, 0, 0});
                } else if (grid[i][j] == 'L') {
                    maskMap.put(i + "-" + j, maskC);
                    maskC++;
                    litterCount++;
                }
            }
        }
        if (litterCount == 0) {
            return 0;
        }
        int[][][] bestEnergy = new int[grid.length][grid[0].length][1 << litterCount];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            int x = poll[0], y = poll[1], totalMoves = poll[2],
                    totalEnergy = poll[3], totalLitter = poll[4], mask = poll[5];
            if (grid[x][y] == 'L') {
                int maskVal = maskMap.get(x + "-" + y);
                if ((mask & (1 << maskVal)) == 0) {
                    totalLitter++;
                    if (totalLitter == litterCount) {
                        return totalMoves;
                    }
                    mask |= (1 << maskVal);
                }
            } else if (grid[x][y] == 'R') {
                totalEnergy = energy;
            }
            if (totalEnergy == 0) {
                continue;
            }
            if (totalEnergy <= bestEnergy[x][y][mask]) {
                continue;
            }
            bestEnergy[x][y][mask] = totalEnergy;
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 'X') {
                    continue;
                }
                bfs.add(new int[] {newX, newY, totalMoves + 1, totalEnergy - 1, totalLitter, mask});
            }
        }
        return -1;
    }

}
