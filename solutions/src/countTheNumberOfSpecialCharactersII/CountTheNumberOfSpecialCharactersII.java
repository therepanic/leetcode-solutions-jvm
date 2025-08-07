package countTheNumberOfSpecialCharactersII;

import java.util.Arrays;

public class CountTheNumberOfSpecialCharactersII {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        Arrays.fill(lower, -1);
        int[] upper = new int[26];
        Arrays.fill(upper, -1);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isLowerCase(chars[i])) {
                lower[ch - 'a'] = i;
            } else {
                ch = Character.toLowerCase(ch);
                if (upper[ch - 'a'] == -1) {
                    upper[ch - 'a'] = i;
                }
            }
        }
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i]) {
                c++;
            }
        }
        return c;
    }
}
