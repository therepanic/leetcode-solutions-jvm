package createGridWithExactlyOnePath;

public class CreateGridWithExactlyOnePath {
    public String[] createGrid(int m, int n) {
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '#';
            }
        }
        for (int j = 0; j < n; j++) {
            matrix[0][j] = '.';
        }
        for (int i = 0; i < m; i++) {
            matrix[i][matrix[i].length - 1] = '.';
        }
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder(n);
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}
