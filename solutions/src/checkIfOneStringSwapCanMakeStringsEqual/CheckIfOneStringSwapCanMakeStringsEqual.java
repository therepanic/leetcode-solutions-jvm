package checkIfOneStringSwapCanMakeStringsEqual;

import java.util.Arrays;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            char f = s1.charAt(i);
            char s = s2.charAt(i);
            if (f != s) diff++;
            if (diff > 2) return false;
            s1Chars[f - 'a']++;
            s2Chars[s - 'a']++;
        }
        return Arrays.equals(s1Chars, s2Chars);
    }
}
