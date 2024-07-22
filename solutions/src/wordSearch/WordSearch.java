package wordSearch;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && check(i, j, board, word, new int[board.length][board[0].length])) {
                    return true;
                }
            }
        }


        return false;
    }

    public static boolean check(int n, int m, char[][] board, String word, int[][] checked) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[n].length || checked[n][m] == 1 || word.charAt(0) != board[n][m]) {
            return false;
        }

        checked[n][m] = 1;

        if (word.length() > 1) {
            word = word.substring(1);
        } else {
            word = "";
        }

        if (word.isEmpty()) {
            return true;
        }

        boolean left = check(n, m - 1, board, word, checked);
        boolean right = check(n, m + 1, board, word, checked);
        boolean down = check(n + 1, m, board, word, checked);
        boolean up = check(n - 1, m, board, word, checked);

        if (!left && !right && !down && !up) {
            checked[n][m] = 0;
        }

        return left || right || down || up;
    }
}
