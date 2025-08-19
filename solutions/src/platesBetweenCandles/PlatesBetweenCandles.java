package platesBetweenCandles;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] sChars = s.toCharArray();
        int[] left = new int[sChars.length];
        int[] right = new int[sChars.length];
        int last = -1;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '|') {
                last = i;
            }
            left[i] = last;
        }
        last = -1;
        for (int i = sChars.length - 1; i >= 0; i--) {
            if (sChars[i] == '|') {
                last = i;
            }
            right[i] = last;
        }
        int[] sum = new int[sChars.length];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] == '*') cnt++;
            sum[i] = cnt;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = right[queries[i][0]];
            int R = left[queries[i][1]];
            if (L == -1 || R == -1 || L >= R) {
                ans[i] = 0;
            } else {
                ans[i] = sum[R] - sum[L];
            }
        }
        return ans;
    }
}
