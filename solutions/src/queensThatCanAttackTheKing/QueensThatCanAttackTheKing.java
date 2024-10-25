package queensThatCanAttackTheKing;

import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackTheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> coordinates = new ArrayList<>();
        int[][] area = new int[8][8];
        area[king[0]][king[1]] = 1;

        for (int[] queen : queens) {
            area[queen[0]][queen[1]] = 2;
        }

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int row = king[0];
            int col = king[1];

            while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                row += dir[0];
                col += dir[1];

                if (row >= 0 && row < 8 && col >= 0 && col < 8 && area[row][col] == 2) {
                    coordinates.add(List.of(row, col));
                    break;
                }
            }
        }

        return coordinates;

    }
}
