package longestBalancedSubstringI;

import java.util.Arrays;

public class LongestBalancedSubstringI {
    public int longestBalanced(String s) {
        int[] c = new int[26];
        char[] chars = s.toCharArray();
        int ans = 1;
        for (int k = 1; k <= s.length(); k++) {
            int l = 0;
            sec: for (int r = 0; r < s.length(); r++) {
                c[chars[r] - 'a']++;
                if (r - l + 1 > k) {
                    c[chars[l] - 'a']--;
                    l++;
                }
                if (r - l + 1 == k) {
                    int dc = -1;
                    for (int i = 0; i < 26; i++) {
                        if (c[i] != 0 && dc == -1) {
                            dc = c[i];
                        } else if (c[i] != 0 && dc != -1 && c[i] != dc) {
                            continue sec;
                        }
                    }
                    ans = Math.max(ans, r - l + 1);
                }
            }
            Arrays.fill(c, 0);
        }
        return ans;
    }
}
