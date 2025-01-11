package constructKPalindromeStrings;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            charCount[c - 'a']++;
        }

        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 != 0) {
                c++;
            }
        }

        return c <= k;
    }
}
