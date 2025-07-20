package findTheMaximumNumberOfMarkedIndices;

import java.util.Arrays;

public class FindTheMaximumNumberOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length / 2;
        int c = 0;
        while (i < nums.length / 2 && j < nums.length) {
            if (2L * nums[i] <= nums[j]) {
                i++;
                j++;
                c++;
            } else {
                j++;
            }
        }
        return c * 2;
    }
}
