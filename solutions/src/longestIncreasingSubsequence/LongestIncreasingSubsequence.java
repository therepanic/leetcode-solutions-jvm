package longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int it = bypass(list, num);

            if (it >= list.size()) {
                list.add(num);
            } else {
                list.set(it, num);
            }
        }

        return list.size();
    }

    public static int bypass(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
