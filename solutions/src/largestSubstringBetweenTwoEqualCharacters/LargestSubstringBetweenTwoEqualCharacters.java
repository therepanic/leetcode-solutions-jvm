package largestSubstringBetweenTwoEqualCharacters;

import java.util.*;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] chars = new int[26][2];
        for (int[] c : chars) {
            Arrays.fill(c, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'][0] == -1) {
                chars[s.charAt(i) - 'a'][0] = i;
            }
            chars[s.charAt(i) - 'a'][1] = i;
        }
        int c = -1;
        for (int i = 0; i < chars.length; i++) {
            c = Math.max(c, chars[i][1] - chars[i][0] - 1);
        }
        return c;
    }
}
