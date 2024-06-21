package threeSum;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            if (i != 0 && currentNum == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (currentNum + nums[l] + nums[r] == 0) {
                    sums.add(List.of(currentNum, nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    l++;
                } else if (currentNum + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return sums;
    }
}
