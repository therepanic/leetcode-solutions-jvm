package theKthLexicographicalStringOfAllHappyStringsOfLengthN;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public String getHappyString(int n, int k) {
        String[] answer = new String[] {""};
        int[] count = new int[1];
        bypass(n, k, "a", count, answer);
        bypass(n, k, "b", count, answer);
        bypass(n, k, "c", count, answer);
        return answer[0];
    }

    private void bypass(int n, int k, String cur, int[] count, String[] ans) {
        if (count[0] > k - 1) return;
        if (cur.length() == n) {
            count[0]++;
            if (count[0] > k - 1) {
                ans[0] = cur;
            }
            return;
        }
        int last = cur.length() - 1;
        if (cur.charAt(last) != 'a') {
            bypass(n, k, cur + 'a', count, ans);
        }
        if (cur.charAt(last) != 'b') {
            bypass(n, k, cur + 'b', count, ans);
        }
        if (cur.charAt(last) != 'c') {
            bypass(n, k, cur + 'c', count, ans);
        }
    }
}
