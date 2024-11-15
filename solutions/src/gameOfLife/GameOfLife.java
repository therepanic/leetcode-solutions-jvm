package gameOfLife;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            temp[i] = board[i].clone();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = neighbourCount(i, j, temp);

                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
    public int neighbourCount(int i, int j, int[][] board){
        int live=0;
        if(i+1<board.length && board[i+1][j]==1) live++;
        if(j+1<board[0].length && board[i][j+1]==1) live++;
        if(i-1>=0 && board[i-1][j]==1) live++;
        if(j-1>=0 && board[i][j-1]==1) live++;

        if(i+1<board.length && j+1<board[0].length && board[i+1][j+1]==1) live++;
        if(i+1<board.length && j-1>=0 && board[i+1][j-1]==1) live++;
        if(i-1>=0 && j+1<board[0].length && board[i-1][j+1]==1) live++;
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1) live++;

        return live;
    }
}
