package longestAlmostPalindromicSubstring;

public class LongestAlmostPalindromicSubstring {
    public int almostPalindromic(String s) {
        int len = -1;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            len = Math.max(len, longestPalindrome(sb.toString()).length());
        }
        return len + 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] t = new char[s.length() * 2 + 1];
        for (int i = 0; i < t.length; i++)
            t[i] = (i % 2 == 0) ? '#' : s.charAt(i / 2);

        int[] p = new int[t.length];
        int center = 0, right = 0;
        int maxLen = 0, maxCenter = 0;

        for (int i = 0; i < t.length; i++) {
            int mirror = 2 * center - i;

            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            while (i - p[i] - 1 >= 0 &&
                    i + p[i] + 1 < t.length &&
                    t[i - p[i] - 1] == t[i + p[i] + 1])
                p[i]++;

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
