package maximumNestingDepthOfTwoValidParenthesesStrings;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int l = 0;
        int r = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                if (l < r) {
                    l++;
                } else {
                    ans[i] = 1;
                    r++;
                }
            } else {
                if (l < r) {
                    l--;
                } else {
                    ans[i] = 1;
                    r--;
                }
            }
        }
        return ans;
    }
}
