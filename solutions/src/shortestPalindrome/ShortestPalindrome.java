package shortestPalindrome;

public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int end = 0;
        firstLoop: for (int i = s.length() - 1; i >= 0; i--) {
            int l = 0;
            int r = i;

            while (r >= 0 && l < s.length() && sChars[l] == sChars[r]) {
                if (l >= r) {
                    end = i;
                    break firstLoop;
                }

                l++;
                r--;
            }
        }

        return new StringBuilder(s).reverse() + s.substring(end + 1);
    }
}
