package maximumPalindromesAfterOperations;

import java.util.Arrays;

public class MaximumPalindromesAfterOperations {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] len = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            len[i] = words[i].length();
        }
        Arrays.sort(len);
        int[] charCount = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                charCount[words[i].charAt(j) - 'a']++;
            }
        }
        int pairs = 0;
        for (int v : charCount) {
            pairs += v / 2;
        }
        for (int i = 0; i < len.length; i++) {
            pairs -= len[i] / 2;
            if (pairs < 0) {
                return i;
            }
        }
        return len.length;
    }
}
