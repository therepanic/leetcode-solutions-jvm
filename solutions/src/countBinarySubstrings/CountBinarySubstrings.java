package countBinarySubstrings;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        int v = 1;
        char[] sChars = s.toCharArray();
        for (int i = 1; i < sChars.length; i++) {
            if (sChars[i] == sChars[i - 1]) {
                v++;
            } else {
                ans += Math.min(prev, v);
                prev = v;
                v = 1;
            }
        }
        return ans + Math.min(prev, v);
    }
}
