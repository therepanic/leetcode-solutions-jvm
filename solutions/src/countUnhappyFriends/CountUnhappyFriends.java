package countUnhappyFriends;

public class CountUnhappyFriends {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }
        int[] partner = new int[n];
        for (int[] pair : pairs) {
            partner[pair[0]] = pair[1];
            partner[pair[1]] = pair[0];
        }
        int c = 0;
        for (int x = 0; x < n; x++) {
            int y = partner[x];
            for (int i = 0; i < rank[x][y]; i++) {
                int u = preferences[x][i];
                if (rank[u][x] < rank[u][partner[u]]) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}
