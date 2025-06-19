package partitionArraySuchThatMaximumDifferenceIsK;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 0;
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[l] > k) {
                c++;
                l = i;
            }
        }
        if (nums[nums.length - 1] - nums[l] <= k) {
            c++;
        }
        return c;
    }

}
