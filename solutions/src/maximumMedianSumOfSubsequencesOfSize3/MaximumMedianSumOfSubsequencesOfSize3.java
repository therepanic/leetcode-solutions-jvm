package maximumMedianSumOfSubsequencesOfSize3;

import java.util.Arrays;

public class MaximumMedianSumOfSubsequencesOfSize3 {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 2;
        long sum = 0;
        while (i < j) {
            sum += nums[j];
            i++;
            j -= 2;
        }
        return sum;
    }
}
