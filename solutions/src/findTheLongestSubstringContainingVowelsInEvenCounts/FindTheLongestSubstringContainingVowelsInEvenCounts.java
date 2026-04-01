package findTheLongestSubstringContainingVowelsInEvenCounts;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        char[] cm = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16,0,0,0,0,0};
        int[] m = new int[32];
        Arrays.fill(m, -1);
        int mask = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= cm[(s.charAt(i) - 'a')];
            if (mask != 0 && m[mask] == -1) {
                m[mask] = i;
            }
            ans = Math.max(ans, i - m[mask]);
        }
        return ans;
    }
}
