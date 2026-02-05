package countElementsWithAtLeastKGreaterValues;

import java.util.*;

public class CountElementsWithAtLeastKGreaterValues {
    public int countElements(int[] nums, int k) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int count = 0;
        for (int val : sorted) {
            int l = 0;
            int r = sorted.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (sorted[mid] > val) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            count += (sorted.length - l >= k ? 1 : 0);
        }
        return count;
    }
}
