package subsequenceAfterOneReplacement;

public class SubsequenceAfterOneReplacement {
    public boolean canMakeSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i = 0;
        int j = 0;
        int m = sChars.length;
        for (char c : tChars) {
            if (i < m && sChars[i] == c) {
                i++;
            }
            i = Math.max(i, j + 1);
            if (j < m && sChars[j] == c) {
                j++;
            }
            if (i == m || j == m) {
                return true;
            }
        }
        return false;
    }
}
