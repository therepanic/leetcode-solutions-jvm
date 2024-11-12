package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (i + 1 != j && nums[j - 1] == nums[j]) {
                    continue;
                }

                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {

                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum > Integer.MAX_VALUE) {
                        l++;
                        continue;
                    }

                    if (sum == target) {
                        answer.add(List.of(nums[i], nums[j], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return answer;
    }
}
