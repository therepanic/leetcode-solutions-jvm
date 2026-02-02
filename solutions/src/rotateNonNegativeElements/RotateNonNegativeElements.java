package rotateNonNegativeElements;

import java.util.ArrayList;
import java.util.List;

public class RotateNonNegativeElements {
    public int[] rotateElements(int[] nums, int k) {
        List<int[]> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                values.add(new int[] {nums[i], i});
            }
        }
        int n = values.size();
        for (int i = 0; i < n; i++) {
            int index = (((i - k) % n) + n) % n;
            nums[values.get(index)[1]] = values.get(i)[0];
        }
        return nums;
    }
}
