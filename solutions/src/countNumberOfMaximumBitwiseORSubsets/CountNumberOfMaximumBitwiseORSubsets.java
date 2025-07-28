package countNumberOfMaximumBitwiseORSubsets;

public class CountNumberOfMaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int[] c = new int[2];
        dfs(nums, c, 0, 0);
        return c[1];
    }

    public void dfs(int[] nums, int[] c, int val, int it) {
        if (it >= nums.length) return;
        int d = val;
        val |= nums[it];
        if (val > c[0]) {
            c[0] = val;
            c[1] = 1;
        } else if (val == c[0]) {
            c[1]++;
        }
        dfs(nums, c, val, it + 1);
        dfs(nums, c, d, it + 1);
    }
}
