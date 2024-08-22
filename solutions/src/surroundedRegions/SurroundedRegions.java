package surroundedRegions;

public class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] checked = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !checked[0][i]) {
                helper1(0, i, board, checked);
            }

            if (board[board.length - 1][i] == 'O' && !checked[board.length - 1][i]) {
                helper1(board.length - 1, i, board, checked);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !checked[i][0]) {
                helper1(i, 0, board, checked);
            }

            if (board[i][board[0].length - 1] == 'O' && !checked[i][board[0].length - 1]) {
                helper1(i, board[0].length - 1, board, checked);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !checked[i][j]) {
                    helper2(i, j, board, checked);
                }
            }
        }
    }

    public void helper1(int n, int m, char[][] board, boolean[][] checked) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[n].length || checked[n][m] || board[n][m] == 'X') {
            return;
        }

        checked[n][m] = true;

        helper1(n - 1, m, board, checked);
        helper1(n + 1, m, board, checked);
        helper1(n, m - 1, board, checked);
        helper1(n, m + 1, board, checked);
    }

    public void helper2(int n, int m, char[][] board, boolean[][] checked) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[n].length || checked[n][m] || board[n][m] == 'X') {
            return;
        }

        checked[n][m] = true;
        board[n][m] = 'X';

        helper2(n - 1, m, board, checked);
        helper2(n + 1, m, board, checked);
        helper2(n, m - 1, board, checked);
        helper2(n, m + 1, board, checked);
    }
}
