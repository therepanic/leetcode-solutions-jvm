package findAPeakElementII;

public class FindAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int r = mat[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int maxRow = 0;
            for (int row = 0; row < mat.length; row++) {
                if (mat[row][mid] > mat[maxRow][mid]) {
                    maxRow = row;
                }
            }
            boolean left = mid - 1 >= 0 && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean right = mid + 1 < mat[0].length && mat[maxRow][mid + 1] > mat[maxRow][mid];
            if (!left && !right) {
                return new int[] {maxRow, mid};
            } else if (left) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return null;
    }
}
