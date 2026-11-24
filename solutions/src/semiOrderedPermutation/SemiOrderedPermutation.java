package semiOrderedPermutation;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int it = -1;
        int ans;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                it = i;
            }
        }
        for (int i = it ; i > 0; i--) {
            int a = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = a;
        }
        ans = it + 1;
        it = -1;
        min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                min = nums[i];
                it = i;
            }
        }
        for (int i = it ; i < nums.length - 1; i++) {
            int a = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = a;
        }
        return ans + nums.length - it;
    }
}
