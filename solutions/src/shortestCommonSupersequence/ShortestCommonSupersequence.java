package shortestCommonSupersequence;

public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] counts = new int[str1.length() + 1][str2.length() + 1];

        char[] text1Chars = str1.toCharArray();
        char[] text2Chars = str2.toCharArray();

        for (int i = 0; i < text1Chars.length; i++) {
            for (int j = 0; j < text2Chars.length; j++) {
                if (text1Chars[i] == text2Chars[j]) {
                    counts[i + 1][j + 1] = counts[i][j] + 1;
                } else {
                    counts[i + 1][j + 1] = Math.max(counts[i][j + 1], counts[i + 1][j]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();

        int n = counts.length - 1;
        int m = counts[0].length - 1;
        while (n > 0 && m > 0) {
            if (text1Chars[n - 1] == text2Chars[m - 1]) {
                lcs.append(text1Chars[n - 1]);
                n--;
                m--;
            } else if (counts[n - 1][m] > counts[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        lcs.reverse();
        StringBuilder scs = new StringBuilder();

        int l = 0, r = 0, k = 0;
        while (l < text1Chars.length || r < text2Chars.length) {
            if (k < lcs.length() && l < text1Chars.length && r < text2Chars.length && text1Chars[l] == lcs.charAt(k) && text2Chars[r] == lcs.charAt(k)) {
                scs.append(lcs.charAt(k));
                k++;
                l++;
                r++;
            } else {
                if (l < text1Chars.length && (k == lcs.length() || text1Chars[l] != lcs.charAt(k))) {
                    scs.append(text1Chars[l]);
                    l++;
                } else if (r < text2Chars.length && (k == lcs.length() || text2Chars[r] != lcs.charAt(k))) {
                    scs.append(text2Chars[r]);
                    r++;
                }
            }
        }

        return scs.toString();
    }
}
