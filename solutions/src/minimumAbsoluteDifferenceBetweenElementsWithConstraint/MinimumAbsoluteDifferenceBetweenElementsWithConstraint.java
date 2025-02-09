package minimumAbsoluteDifferenceBetweenElementsWithConstraint;

import java.util.*;

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> numSet = new TreeSet<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (i >= x) {
                numSet.add(nums.get(i - x   ));
            }
            if (!numSet.isEmpty()) {
                Integer low = numSet.floor(nums.get(i));
                Integer high = numSet.ceiling(nums.get(i));
                if (low != null) minDiff = Math.min(minDiff, Math.abs(nums.get(i) - low));
                if (high != null) minDiff = Math.min(minDiff, Math.abs(nums.get(i) - high));
            }
        }
        return minDiff;
    }
}
