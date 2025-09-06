package minimumLengthOfStringAfterDeletingSimilarEnds;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        char[] sChars = s.toCharArray();
        int l = 0;
        int r = sChars.length - 1;
        while (l < r && sChars[l] == sChars[r]) {
            char ch = sChars[l];
            while (l <= r && sChars[l] == ch) {
                l++;
            }
            while (l <= r && sChars[r] == ch) {
                r--;
            }
        }
        return r - l + 1;
    }
}
