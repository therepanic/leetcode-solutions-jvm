package checkIfMoveIsLegal;

public class CheckIfMoveIsLegal {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dir = new int[][] {{1, 1}, {1, 0}, {1, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}};
        board[rMove][cMove] = color;
        for (int i = 0; i < dir.length; i++) {
            int x = rMove + dir[i][0];
            int y = cMove + dir[i][1];
            int c = 2;
            while (x < board.length && x >= 0 && y < board[x].length && y >= 0 && board[x][y] != color && board[x][y] != '.') {
                x += dir[i][0];
                y += dir[i][1];
                c++;
            }
            if (x < board.length && x >= 0 && y < board[x].length && y >= 0 && board[x][y] == color && c >= 3) {
                return true;
            }
        }
        return false;
    }
}
