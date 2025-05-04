package cycleLengthQueriesInATree;

public class CycleLengthQueriesInATree {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            answer[i]++;
            while (left != right) {
                if (left > right) {
                    left /= 2;
                } else {
                    right /= 2;
                }
                answer[i]++;
            }
        }
        return answer;
    }

}
