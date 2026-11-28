package longestSubsequenceWithLimitedSum;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] A, int[] queries) {
        Arrays.sort(A);
        int n = A.length;
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 1; i < n; i++) {
            A[i] += A[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int j = Arrays.binarySearch(A, queries[i]);
            res[i] = Math.abs(j + 1);
        }
        return res;
    }
}
