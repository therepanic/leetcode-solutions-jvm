package maximumNestingDepthOfTheParentheses;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int c = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                c++;
            } else if (ch == ')') {
                c--;
            }
            ans = Math.max(c, ans);
        }
        return ans;
    }
}
