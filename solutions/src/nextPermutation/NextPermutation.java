package nextPermutation;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
            Arrays.sort(nums, i + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
