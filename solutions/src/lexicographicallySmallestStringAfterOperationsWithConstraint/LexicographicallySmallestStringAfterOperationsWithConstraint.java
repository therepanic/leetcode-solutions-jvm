package lexicographicallySmallestStringAfterOperationsWithConstraint;

public class LexicographicallySmallestStringAfterOperationsWithConstraint {
    public String getSmallestString(String s, int k) {
        char[] sChars = s.toCharArray();
        int curK = 0;
        for (int i = 0; i < sChars.length; i++) {
            char ch = sChars[i];
            int v = ch - 'a';
            int forward = (26 - v) % 26;
            int cost = Math.min(forward, v);
            if (curK + cost <= k) {
                curK += cost;
                sChars[i] = 'a';
            } else {
                sChars[i] = (char) ((v - (k - curK)) + 'a');
                break;
            }
        }
        return String.valueOf(sChars);
    }
}
