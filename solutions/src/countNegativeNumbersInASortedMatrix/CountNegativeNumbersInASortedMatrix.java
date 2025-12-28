package countNegativeNumbersInASortedMatrix;

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int negativeCount = 0;
        for (int i = 0; i < grid.length; i++) {
            int it = 0;
            int jt = grid[i].length - 1;
            while (it <= jt) {
                int mid = it + (jt - it) / 2;
                if (grid[i][mid] >= 0) {
                    it = mid + 1;
                } else {
                    jt = mid - 1;
                }
            }
            negativeCount += grid[i].length - it;
        }
        return negativeCount;
    }
}
