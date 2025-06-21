package removingMinimumAndMaximumFromArray;

public class RemovingMinimumAndMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        boolean min = false, max = false;
        int minDeletionsA = 0;
        for (int i = 0; i < nums.length; i++) {
            minDeletionsA++;
            if (minVal == nums[i]) {
                min = true;
            } else if (maxVal == nums[i]) {
                max = true;
            }
            if (min && max) {
                break;
            }
        }
        min = false;
        max = false;
        int minDeletionsB = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            minDeletionsB++;
            if (minVal == nums[i]) {
                min = true;
            } else if (maxVal == nums[i]) {
                max = true;
            }
            if (min && max) {
                break;
            }
        }
        int minDeletionsC = 0;
        for (int i = 0; i < nums.length; i++) {
            minDeletionsC++;
            if (nums[i] == minVal) {
                break;
            } else if (nums[i] == maxVal) {
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            minDeletionsC++;
            if (nums[i] == maxVal || nums[i] == minVal) {
                break;
            }
        }
        return Math.min(Math.min(minDeletionsA, minDeletionsB), minDeletionsC);
    }
}
