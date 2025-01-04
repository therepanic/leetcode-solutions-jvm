package uniqueLength3PalindromicSubsequences;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        boolean[][] left = new boolean[s.length()][26];
        boolean[][] right = new boolean[s.length()][26];

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                left[i] = left[i - 1].clone();
            }
            left[i][s.charAt(i) - 'a'] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1) {
                right[i] = right[i + 1].clone();
            }
            right[i][s.charAt(i) - 'a'] = true;
        }

        Set<String> result = new HashSet<>();
        for (int i = 1; i < s.length() - 1; i++) {
            for (int c = 0; c < 26; c++) {
                if (left[i - 1][c] && right[i + 1][c]) {
                    result.add((char) (c + 'a') + "" + s.charAt(i) + (char) (c + 'a'));
                }
            }
        }

        return result.size();
    }

}
