package validPalindromeII;

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        return validPalindrome(s.toCharArray(), 0, s.length() - 1, false);
    }

    public static boolean validPalindrome(char[] sChars, int l, int r, boolean result) {
        while (l <= r) {
            if (sChars[l] == sChars[r]) {
                l++;
                r--;
            } else if (sChars[l] != sChars[r] && !result) {
                return validPalindrome(sChars, l + 1, r, true) || validPalindrome(sChars, l, r - 1, true);
            } else if (sChars[l] != sChars[r] && result) {
                return false;
            }
        }

        return true;
    }
}
