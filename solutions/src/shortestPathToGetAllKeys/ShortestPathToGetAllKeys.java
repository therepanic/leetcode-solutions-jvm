package shortestPathToGetAllKeys;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {

    public static int shortestPathAllKeys(String[] grid) {
        char[][] gridChars = new char[grid.length][grid[0].length()];
        Set<String> visited = new HashSet<>();
        Queue<int[]> bfs = new ArrayDeque<>();
        int keyCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                gridChars[i][j] = grid[i].charAt(j);
                if (gridChars[i][j] == '@') {
                    bfs.add(new int[] {i, j, 0, 0, 0});
                } else if (Character.isLetter(gridChars[i][j]) && Character.isLowerCase(gridChars[i][j])) {
                    keyCount++;
                }
            }
        }
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            int x = poll[0], y = poll[1];
            String key = x + "-" + y + "-" + poll[4];
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);
            if (Character.isLetter(gridChars[x][y])) {
                if (Character.isLowerCase(gridChars[x][y])) {
                    int ch = gridChars[x][y] - 'a';
                    if ((poll[4] & (1 << ch)) == 0) {
                        poll[3]++;
                        if (poll[3] == keyCount) {
                            return poll[2];
                        }
                        poll[4] |= (1 << ch);
                    }
                } else {
                    int ch = Character.toLowerCase(gridChars[x][y]) - 'a';
                    if ((poll[4] & (1 << ch)) == 0) {
                        continue;
                    }
                }
            }
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= gridChars.length || newY >= gridChars[0].length || gridChars[newX][newY] == '#') {
                    continue;
                }
                bfs.add(new int[] {newX, newY, poll[2] + 1, poll[3], poll[4]});
            }
        }
        return -1;
    }

}
