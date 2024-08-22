package battleshipsInABoard;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    helper(i, j, board);
                    count++;
                }
            }
        }

        return count;
    }

    public void helper(int n, int m, char[][] board) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[n].length || board[n][m] != 'X') {
            return;
        }

        board[n][m] = '.';

        helper(n - 1, m, board);
        helper(n + 1, m, board);
        helper(n, m - 1, board);
        helper(n, m + 1, board);
    }
}
