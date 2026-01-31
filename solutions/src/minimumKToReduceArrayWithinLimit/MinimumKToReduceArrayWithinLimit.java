package minimumKToReduceArrayWithinLimit;

public class MinimumKToReduceArrayWithinLimit {
    public static int minimumK(int[] nums) {
        int l = 1;
        int r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            r = Math.max(nums[i], r);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;
            }
            if ((long) sum <= (long) mid * mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
