package maximumNumberOfRemovableCharacters;

public class MaximumNumberOfRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sChars = s.toCharArray();
        char[] backup = sChars.clone();
        char[] pChars = p.toCharArray();
        int l = 0;
        int r = removable.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            for (int i = 0; i < mid; i++) {
                sChars[removable[i]] = '.';
            }
            if (isSubsequence(sChars, pChars)) {
                l = mid + 1;
            } else {
                for (int i = 0; i < mid; i++) {
                    sChars[removable[i]] = backup[removable[i]];
                }
                r = mid - 1;
            }
        }
        return l - 1;
    }

    public boolean isSubsequence(char[] s, char[] p) {
        int i = 0;
        int j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                j++;
            }
            i++;
        }
        return j == p.length;
    }
}
