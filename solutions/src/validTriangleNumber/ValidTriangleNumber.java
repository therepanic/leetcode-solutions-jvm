package validTriangleNumber;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                c += k - j - 1;
            }
        }
        return c;
    }
}
