package adjacentIncreasingSubarraysDetectionII;

import java.util.*;

public class AdjacentIncreasingSubarraysDetectionII {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int l = 1;
        int r = nums.size() - 1;
        int ans = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (hasIncreasingSubarrays(nums, mid)) {
                ans = mid;

                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int l = 0;
        Set<Integer> indexes = new HashSet<>();
        if (k <= 1) return true;
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
