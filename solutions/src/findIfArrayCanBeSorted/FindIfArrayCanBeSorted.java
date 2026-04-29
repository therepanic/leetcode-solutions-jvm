package findIfArrayCanBeSorted;

import java.util.*;

public class FindIfArrayCanBeSorted {
    public boolean canSortArray(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = i;
            int bits = Integer.bitCount(nums[i]);
            while (j < nums.length && Integer.bitCount(nums[j]) == bits) {
                j++;
            }
            Arrays.sort(nums, i, j);
            i = j;
        }
        for (int j = 1 ; j < nums.length; j++) {
            if (nums[j] < nums[j - 1]) {
                return false;
            }
        }
        return true;
    }
}
