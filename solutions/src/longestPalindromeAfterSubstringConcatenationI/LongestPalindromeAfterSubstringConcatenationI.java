package longestPalindromeAfterSubstringConcatenationI;

public class LongestPalindromeAfterSubstringConcatenationI {
    public int longestPalindrome(String s, String t) {
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                for (int k = 0; k < t.length(); k++) {
                    for (int g = k; g <= t.length(); g++) {
                        String candidate = s.substring(i, j) + t.substring(k, g);
                        if (isPalindrome(candidate)) {
                            maxLength = Math.max(maxLength, candidate.length());
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
