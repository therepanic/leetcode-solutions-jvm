package allDivisionsWithTheHighestScoreOfABinaryArray;

import java.util.ArrayList;
import java.util.List;

public class AllDivisionsWithTheHighestScoreOfABinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + (nums[i] == 0 ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] + (nums[i] == 1 ? 1 : 0);
        }
        int s = 0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            int c = left[i] + right[i];
            if (c > s) {
                values.clear();
                values.add(i);
                s = c;
            } else if (c == s) {
                values.add(i);
            }
        }
        return values;
    }
}
