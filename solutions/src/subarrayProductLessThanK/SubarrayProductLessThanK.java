package subarrayProductLessThanK;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;

        int l = 0;
        int product = 0;

        for (int r = 0; r < nums.length; r++) {
            if (product == 0) {
                product = nums[r];
            } else {
                product *= nums[r];
            }

            while (l <= r  && product >= k) {
                product /= nums[l];
                l++;
            }

            count += r - l + 1;
        }

        return count;
    }
}
