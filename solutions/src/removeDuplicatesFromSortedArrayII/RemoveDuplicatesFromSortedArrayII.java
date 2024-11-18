package removeDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int curVal = -1;
        int count = 0;

        int spaceCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == curVal) {
                if (count > 2) {
                    spaceCount++;
                    nums[i] = Integer.MAX_VALUE - 2;
                }
                count++;
            } else {
                curVal = num;
                count = 1;
            }
        }

        Arrays.sort(nums);

        return nums.length - spaceCount;
    }
}
