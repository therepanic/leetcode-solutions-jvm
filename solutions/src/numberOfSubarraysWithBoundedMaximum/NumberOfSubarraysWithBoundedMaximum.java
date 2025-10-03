package numberOfSubarraysWithBoundedMaximum;

public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return (int) (numSubarrayBoundedMax(nums, right) - numSubarrayBoundedMax(nums, left - 1));
    }

    public long numSubarrayBoundedMax(int[] nums, int then) {
        int l = 0;
        long count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] > then) {
                int size = r - l;
                count += ((long) size * (size + 1)) / 2;
                l = r + 1;
            }
        }
        int size = nums.length - l;
        count += ((long) size * (size + 1)) / 2;
        return count;
    }
}
