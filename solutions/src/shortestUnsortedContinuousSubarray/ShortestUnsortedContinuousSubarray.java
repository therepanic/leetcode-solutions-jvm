package shortestUnsortedContinuousSubarray;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        int val = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= val) {
                val = nums[i];
            } else {
                end = i;
            }
        }
        val = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= val) {
                val = nums[i];
            } else {
                start = i;
            }
        }
        return start == -1 ? 0 : end - start + 1;
    }
}
