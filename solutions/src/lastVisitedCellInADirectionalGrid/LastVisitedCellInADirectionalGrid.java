package lastVisitedCellInADirectionalGrid;

public class LastVisitedCellInADirectionalGrid {
    public int[] lastVisitedCell(char[][] grid) {
        int i = 0, j = 0;
        int lastI = 0, lastJ = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !visited[i][j]) {
            visited[i][j] = true;
            char ch = grid[i][j];
            lastI = i;
            lastJ = j;
            if (ch == 'L') {
                j--;
            } else if (ch == 'R') {
                j++;
            } else if (ch == 'U') {
                i--;
            } else {
                i++;
            }
        }
        return new int[] {lastI, lastJ};
    }
}
