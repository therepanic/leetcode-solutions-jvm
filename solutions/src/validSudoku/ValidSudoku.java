package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int value = board[i][j] - '0';

                    if (values.contains(value)) {
                        return false;
                    } else {
                        values.add(value);
                    }
                }
            }
            values.clear();
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (Character.isDigit(board[j][i])) {
                    int value = board[j][i] - '0';

                    if (values.contains(value)) {
                        return false;
                    } else {
                        values.add(value);
                    }
                }
            }
            values.clear();
        }

        for (int q = 0; q < board.length; q += 3) {
            for (int i = 0; i < board[0].length; i++) {
                if (i == 0 || i >= 3 && i % 3 == 0) {
                    values.clear();
                }

                for (int j = q; j <= q + 2; j++) {
                    if (Character.isDigit(board[j][i])) {
                        int value = board[j][i] - '0';
                        if (values.contains(value)) {
                            return false;
                        } else {
                            values.add(value);
                        }
                    }
                }
            }
        }

        return true;
    }
}
