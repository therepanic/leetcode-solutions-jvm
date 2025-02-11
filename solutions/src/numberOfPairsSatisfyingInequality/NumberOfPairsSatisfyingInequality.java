package numberOfPairsSatisfyingInequality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfPairsSatisfyingInequality {
    public static long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        List<Integer> nums = new ArrayList<>();
        long c = 0;
        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i] - nums2[i] + diff;
            int l = 0;
            int r = nums.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) <= val) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            c += l;
            int pos = Collections.binarySearch(nums, nums1[i] - nums2[i]);
            if (pos < 0) pos = -pos - 1;
            nums.add(pos, nums1[i] - nums2[i]);
        }
        return c;
    }
}
