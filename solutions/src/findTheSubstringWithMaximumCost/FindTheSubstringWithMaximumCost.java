package findTheSubstringWithMaximumCost;

import java.util.Arrays;

public class FindTheSubstringWithMaximumCost {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] values = new int[26];
        Arrays.fill(values, Integer.MAX_VALUE);
        for (int i = 0; i < chars.length(); i++) {
            values[chars.charAt(i) - 'a'] = vals[i];
        }
        int maxCost = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int val = values[ch] == Integer.MAX_VALUE ? ch + 1 : values[ch];
            cur = Math.max(cur + val, val);
            maxCost = Math.max(maxCost, cur);
        }
        return maxCost;
    }
}
