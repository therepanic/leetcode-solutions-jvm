package collectingChocolates;

public class CollectingChocolates {
    public long minCost(int[] nums, int x) {
        long ans = Long.MAX_VALUE;
        int[] b = nums.clone();
        for (int k = 0; k < nums.length; k++) {
            for (int i = 0; i < nums.length; i++) {
                b[i] = Math.min(b[i], nums[(i + k) % nums.length]);
            }
            long s = 0;
            for (int i = 0; i < b.length; i++) {
                s += b[i];
            }
            ans = Math.min((long) k * x + s, ans);
        }
        return ans;
    }
}
