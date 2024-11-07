package checkIfStringsCanBeMadeEqualWithOperationsII;

import java.util.Arrays;

public class CheckIfStringsCanBeMadeEqualWithOperationsII {
    public boolean checkStrings(String s1, String s2) {
        int[] charCount = new int[26];
        int[] charCount1 = new int[26];

        char[] s1Chars = s1.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                charCount[s1Chars[i] - 'a']++;
            } else {
                charCount1[s1Chars[i] - 'a']++;
            }
        }

        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                charCount[s2Chars[i] - 'a']--;
            } else {
                charCount1[s2Chars[i] - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            int val = charCount[i];
            int val1 = charCount1[i];

            if (val != 0 || val1 != 0) {
                return false;
            }
        }

        return true;
    }
}
