package longestPalindromicSubsequence;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        return longestCommonSubsequence(s, reversed);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] counts = new int[text1.length() + 1][text2.length() + 1];

        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();

        for (int i = 0; i < text1Chars.length; i++) {
            for (int j = 0; j < text2Chars.length; j++) {
                if (text1Chars[i] == text2Chars[j]) {
                    counts[i + 1][j + 1] = counts[i][j] + 1;
                } else {
                    counts[i + 1][j + 1] = Math.max(counts[i][j + 1], counts[i + 1][j]);
                }
            }
        }

        return counts[counts.length - 1][counts[0].length - 1];
    }
}
