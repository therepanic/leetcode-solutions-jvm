package minimumMovesToMakeArrayComplementary;

public class MinimumMovesToMakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int[] w = new int[limit * 2 + 2];
        for (int i = 0; i < nums.length / 2; i++) {
            int l =  nums[i];
            int r = nums[nums.length - i - 1];
            w[Math.min(l, r) + 1]--;
            w[Math.max(l, r) + limit + 1]++;
            w[l + r]--;
            w[l + r + 1]++;
        }
        int ans = Integer.MAX_VALUE;
        int c = nums.length;
        for (int i = 2; i <= limit * 2; i++) {
            c += w[i];
            ans = Math.min(c, ans);
        }
        return ans;
    }
}
