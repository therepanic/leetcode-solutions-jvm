package validElementsInAnArray;

import java.util.ArrayList;
import java.util.List;

public class ValidElementsInAnArray {
    public List<Integer> findValidElements(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        List<Integer> ok = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == nums.length - 1) {
                ok.add(nums[i]);
                continue;
            }
            if (nums[i] <= left[i - 1] && nums[i] <= right[i + 1]) {
                continue;
            }
            ok.add(nums[i]);
        }
        return ok;
    }
}
