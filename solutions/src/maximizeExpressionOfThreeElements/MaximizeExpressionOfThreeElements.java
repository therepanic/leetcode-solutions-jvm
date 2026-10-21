package maximizeExpressionOfThreeElements;

import java.util.Arrays;

public class MaximizeExpressionOfThreeElements {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        return -nums[0] + nums[nums.length - 1] + nums[nums.length - 2];
    }

}
