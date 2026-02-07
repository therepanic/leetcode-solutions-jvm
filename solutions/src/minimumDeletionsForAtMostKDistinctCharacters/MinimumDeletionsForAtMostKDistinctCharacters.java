package minimumDeletionsForAtMostKDistinctCharacters;

import java.util.Arrays;

public class MinimumDeletionsForAtMostKDistinctCharacters {
    public int minDeletion(String s, int k) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        int l = 0;
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                l++;
            }
        }
        Arrays.sort(c);
        int ans = 0;
        for (int i = 0; i < 26 && l > k; i++) {
            if (c[i] != 0) {
                l--;
                ans += c[i];
            }
        }
        return ans;
    }
}
