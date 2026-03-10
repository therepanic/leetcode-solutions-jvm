package wiggleSortII;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int mid = (nums.length - 1) / 2;
        int end = nums.length - 1;
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = newNums[mid--];
            } else {
                nums[i] = newNums[end--];
            }
        }
    }
}
