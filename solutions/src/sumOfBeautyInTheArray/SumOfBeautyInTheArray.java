package sumOfBeautyInTheArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumOfBeautyInTheArray {
    public static int sumOfBeauties(int[] nums) {
        int[] leftMax = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            leftMax[i] = max;
        }
        int[] rightMax = new int[nums.length];
        max = Integer.MAX_VALUE;
        for (int i = rightMax.length - 1; i >= 0; i--) {
            max = Math.min(max, nums[i]);
            rightMax[i] = max;
        }
        int beauty = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftMax[i - 1] && nums[i] < rightMax[i + 1]) {
                beauty += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                beauty += 1;
            }
        }
        return beauty;
    }
}
