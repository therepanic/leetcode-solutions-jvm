package countSubstringsThatCanBeRearrangedToContainAStringII;

public class CountSubstringsThatCanBeRearrangedToContainAStringII {
    public static long validSubstringCount(String word1, String word2) {
        long count = 0;
        int[] charCount2 = new int[26];
        for (char c : word2.toCharArray()) {
            charCount2[c - 'a']++;
        }
        int[] charCount1 = new int[26];
        int l = 0;
        char[] word1Chars = word1.toCharArray();
        for (int r = 0; r < word1.length(); r++) {
            char c = word1Chars[r];
            charCount1[c - 'a']++;
            while (l <= r && isValid(charCount1, charCount2)) {
                count += word1.length() - r;
                charCount1[word1Chars[l] - 'a']--;
                l++;
            }
        }
        return count;
    }

    private static boolean isValid(int[] charCount1, int[] charCount2) {
        for (int i = 0; i < 26; i++) {
            if (charCount1[i] < charCount2[i]) {
                return false;
            }
        }
        return true;
    }
}
