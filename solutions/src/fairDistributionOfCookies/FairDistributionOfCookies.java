package fairDistributionOfCookies;

public class FairDistributionOfCookies {
    public int distributeCookies(int[] cookies, int k) {
        int[] kids = new int[k];
        int[] ans = new int[] {Integer.MAX_VALUE};
        helper(0, cookies, kids, ans);
        return ans[0];
    }

    public void helper(int it, int[] cookies, int[] kids, int[] ans) {
        if (it == cookies.length) {
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < kids.length; i++) {
                v = Math.max(v, kids[i]);
            }
            ans[0] = Math.min(ans[0], v);
        } else {
            int v = -1;
            for (int i = 0; i < kids.length; i++) {
                kids[i] += cookies[it];
                helper(it + 1, cookies, kids, ans);
                kids[i] -= cookies[it];
            }
        }
    }

}
