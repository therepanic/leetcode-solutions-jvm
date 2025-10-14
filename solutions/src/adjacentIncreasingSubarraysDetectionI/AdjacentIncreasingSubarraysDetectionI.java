package adjacentIncreasingSubarraysDetectionI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int l = 0;
        Set<Integer> indexes = new HashSet<>();
        if (k == 1) return true;
        for (int r = 1; r < nums.size(); r++) {
            if (nums.get(r) <= nums.get(r - 1)) {
                l = r;
                continue;
            }
            if (r - l + 1 > k) {
                l++;
                if (nums.get(l) >= nums.get(l + 1) || nums.get(r) <= nums.get(r - 1)) {
                    l = r;
                    continue;
                }
            }
            if (r - l + 1 == k) {
                if (indexes.contains(l - k)) {
                    return true;
                }
                indexes.add(l);
            }
        }
        return false;
    }
}
