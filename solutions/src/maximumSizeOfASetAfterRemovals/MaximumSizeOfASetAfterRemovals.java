package maximumSizeOfASetAfterRemovals;

import java.util.HashSet;
import java.util.Set;

public class MaximumSizeOfASetAfterRemovals {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max = n / 2;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int v : nums1) {
            set1.add(v);
        }
        for (int v : nums2) {
            set2.add(v);
        }
        int uniq1 = 0;
        int uniq2 = 0;
        for (int v : set1) {
            if (!set2.contains(v)) {
                uniq1++;
            }
        }
        for (int v : set2) {
            if (!set1.contains(v)) {
                uniq2++;
            }
        }
        int common = set1.size() - uniq1;
        int best1 = Math.min(uniq1, max);
        int best2 = Math.min(uniq2, max);
        int rem1 = max - best1;
        int rem2 = max - best2;
        int takeCommon = Math.min(rem1 + rem2, common);
        return best1 + best2 + takeCommon;
    }
}
