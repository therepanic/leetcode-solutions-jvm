package maximumBeautyOfAnArrayAfterApplyingOperation;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (l < nums.length && nums[l] - nums[r] <= 2 * k) {
                l++;
            }
            answer = Math.max(answer, l - r);
        }
        return answer;
    }
}
