package minimumOperationsToReduceXToZero;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int l = 0;
        int rest = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum -= nums[r];
            while (l <= r && sum < x) {
                sum += nums[l];
                l++;
            }
            if (sum == x) {
                rest = Math.min(rest, nums.length - (r - l) - 1);
            }
        }
        return rest == Integer.MAX_VALUE ? -1 : rest;
    }
}
