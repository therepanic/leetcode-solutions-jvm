package whereWillTheBallFall;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] answers = new int[grid[0].length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = bypass(i, grid);
        }
        return answers;
    }

    public int bypass(int startJ, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][startJ] == 1 && startJ != grid[0].length - 1 && grid[i][startJ + 1] != -1) {
                startJ++;
            } else if (grid[i][startJ] == -1 && startJ != 0 && grid[i][startJ - 1] != 1){
                startJ--;
            } else {
                return -1;
            }
        }
        return startJ;
    }
}
