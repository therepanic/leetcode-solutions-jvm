package minesweeper;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> bfs = new ArrayDeque<>(List.of(click));
        int[] left = new int[] {1, 1, 1, -1 ,-1, -1, 0, 0};
        int[] up = new int[] {1, -1, 0, 1, -1, 0, 1, -1};
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            if (poll[0] < 0 || poll[1] < 0 || poll[0] >= board.length || poll[1] >= board[0].length || board[poll[0]][poll[1]] != 'E') {
                continue;
            }
            int c = checkOnMinesAround(board, poll[0], poll[1], left, up);
            if (c != 0) {
                board[poll[0]][poll[1]] = Character.forDigit(c, 10);
                continue;
            } else {
                board[poll[0]][poll[1]] = 'B';
            }
            for (int i = 0; i < 8; i++) {
                int x = poll[0] + left[i];
                int y = poll[1] + up[i];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                bfs.add(new int[] {x, y});
            }
        }
        return board;
    }

    private int checkOnMinesAround(char[][] board, int m, int n, int[] left, int[] up) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = m + left[i];
            int y = n + up[i];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        return count;
    }
}
