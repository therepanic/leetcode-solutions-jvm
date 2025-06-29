package numberOfSubsequencesThatSatisfyTheGivenSumCondition;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] preCalculated = new int[nums.length];
        preCalculated[0] = 1;
        for (int i = 1; i < preCalculated.length; i++) {
            preCalculated[i] = ((preCalculated[i - 1] * 2) % 1000000007);
        }
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[r] + nums[l] <= target) {
                count = (count + preCalculated[r - l]) % 1000000007;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }

}
