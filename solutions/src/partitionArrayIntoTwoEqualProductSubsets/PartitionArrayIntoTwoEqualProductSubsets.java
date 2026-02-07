package partitionArrayIntoTwoEqualProductSubsets;

import java.math.BigDecimal;

public class PartitionArrayIntoTwoEqualProductSubsets {
    public boolean checkEqualPartitions(int[] nums, long target) {
        BigDecimal v = new BigDecimal(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            v = v.multiply(new BigDecimal(nums[i]));
        }
        BigDecimal t = new BigDecimal(target);
        if (!t.multiply(t).equals(v)) {
            return false;
        }
        return check(nums, target, 1, 0);
    }

    public boolean check(int[] nums, long target, long cur, int it) {
        if (it == nums.length) return false;
        if (cur == target) return true;
        for (int i = it; i < nums.length; i++) {
            long t = nums[i];
            if (cur > target / t) {
                continue;
            }
            long mul = cur * t;
            if (check(nums, target, mul, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
