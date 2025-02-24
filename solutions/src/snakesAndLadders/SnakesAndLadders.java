package snakesAndLadders;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        Queue<int[]> queue = new ArrayDeque<>(List.of(new int[] {1, 0, 0, 0}));
        int size = board.length * board.length;
        boolean[] visited = new boolean[size + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cell = poll[0];
            int moves = poll[1];

            if (cell == size) {
                return moves;
            }

            for (int d = 1; d <= 6; d++) {
                int nextCell = cell + d;
                if (nextCell > size) continue;

                int[] coords = getCoordinates(nextCell, board.length);
                if (board[coords[0]][coords[1]] != -1) {
                    nextCell = board[coords[0]][coords[1]];
                }

                if (!visited[nextCell]) {
                    visited[nextCell] = true;
                    queue.add(new int[]{nextCell, moves + 1});
                }
            }
        }
        return -1;
    }
    public static int[] getCoordinates(int cell, int N) {
        int i = (N - 1) - (cell - 1) / N;
        int j = ((N - 1 - i) % 2 == 0) ? (cell - 1) % N : (N - 1 - (cell - 1) % N);
        return new int[]{i, j};
    }
}
