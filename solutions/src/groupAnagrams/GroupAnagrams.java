package groupAnagrams;

import java.util.*;

public class GroupAnagrams {
    public int[] productExceptSelf(int[] nums) {
        int numSum = 1;

        for (int i : nums) {
            numSum *= i;
        }

        int[] newNum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                newNum[i] = 0;
            } else {
                newNum[i] = numSum / nums[i];
            }
        }

        return newNum;
    }
}
