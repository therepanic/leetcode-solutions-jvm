package rowWithMaximumOnes;

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] a = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int c = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }

            if (c > a[1]) {
                a[1] = c;
                a[0] = i;
            }
        }
        return a;
    }
}
