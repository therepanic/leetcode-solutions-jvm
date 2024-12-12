package nearestExitFromEntranceInMaze;

import java.util.*;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> move = new ArrayDeque<>();

        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == '.' && (i != entrance[0] || 0 != entrance[1])) {
                move.add(new int[] {i, 0, 0});
            }

            if (maze[i][maze[i].length - 1] == '.' && (i != entrance[0] || maze[i].length - 1 != entrance[1])) {
                move.add(new int[] {i, maze[i].length - 1, 0});
            }
        }

        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] == '.' && (0 != entrance[0] || i != entrance[1])) {
                move.add(new int[] {0, i, 0});
            }

            if (maze[maze.length - 1][i] == '.' && (maze.length - 1 != entrance[0] || i != entrance[1])) {
                move.add(new int[] {maze.length - 1, i, 0});
            }
        }

        boolean[][] checked = new boolean[maze.length][maze[0].length];

        while (!move.isEmpty()) {
            int[] poll = move.poll();

            if (poll[0] < 0 || poll[1] < 0 || poll[0] >= maze.length || poll[1] >= maze[0].length || maze[poll[0]][poll[1]] == '+') {
                continue;
            }

            if (checked[poll[0]][poll[1]]) continue;

            if (poll[0] == entrance[0] && poll[1] == entrance[1]) {
                return poll[2];
            }

            checked[poll[0]][poll[1]] = true;

            move.add(new int[] {poll[0] + 1, poll[1], poll[2] + 1});
            move.add(new int[] {poll[0] - 1, poll[1], poll[2] + 1});
            move.add(new int[] {poll[0], poll[1] + 1, poll[2] + 1});
            move.add(new int[] {poll[0], poll[1] - 1, poll[2] + 1});
        }

        return -1;
    }
}
