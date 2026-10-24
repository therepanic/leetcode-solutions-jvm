package countMagicalSubstringPairsI;

public class CountMagicalSubstringPairsI {
    public int countMagicalPairs(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        int[][] cnt = new int[n][27];
        for (int i = 0; i < n; i++) {
            int[] c = new int[26];
            int d = 0;
            for (int j = i; j < n; j++) {
                if (c[ss[j] - 'a']++ == 0) d++;
                cnt[j][d]++;
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 1; i--) {
            int[] c = new int[26];
            int d = 0;
            for (int j = i; j >= 1; j--) {
                if (c[ss[j] - 'a']++ == 0) d++;
                ans += cnt[j - 1][d];
            }
        }
        return ans;
    }
}
