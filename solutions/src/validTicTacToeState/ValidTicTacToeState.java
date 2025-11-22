package validTicTacToeState;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X') {
                    x++;
                }  else if (ch == 'O') {
                    o++;
                }
            }
        }
        if (o > x) return false;
        if (x - o > 1) return false;
        boolean xWinner = isWinner(board, 'X');
        boolean oWinner = isWinner(board, 'O');
        if (xWinner && oWinner) return false;
        if (xWinner && x != o + 1) return false;
        if (oWinner && x != o) return false;
        return true;
    }

    private boolean isWinner(String[] board, char ch) {
        String win = ("" + ch).repeat(3);
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(win) || board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }
        return (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch)
                || board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch;
    }
}
