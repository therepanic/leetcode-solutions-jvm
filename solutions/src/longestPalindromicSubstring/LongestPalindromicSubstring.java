package longestPalindromicSubstring;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String longestPalindrome = "";
        char[] sChars = s.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            getPalindrome(sChars, sb, i, i);

            if (sb.length() > longestPalindrome.length()) {
                longestPalindrome = sb.toString();
            }

            sb.delete(0, sb.length());

            getPalindrome(sChars, sb, i, i + 1);


            if (sb.length() > longestPalindrome.length()) {
                longestPalindrome = sb.toString();
            }

            sb.delete(0, sb.length());
        }

        return longestPalindrome;
    }

    public static void getPalindrome(char[] sChars, StringBuilder sb, int l, int r) {
        while (l >= 0 && r < sChars.length) {
            if (l != r && sChars[l] == sChars[r]) {
                sb.append(sChars[r]);

                sb.insert(0, sChars[l]);
            } else if (l == r && sChars[l] == sChars[r]){
                sb.append(sChars[r]);
            } else {
                break;
            }

            l--;
            r++;
        }
    }
}
