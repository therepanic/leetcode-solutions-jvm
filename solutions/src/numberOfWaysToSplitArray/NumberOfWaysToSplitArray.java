package numberOfWaysToSplitArray;

public class NumberOfWaysToSplitArray {
    public static int waysToSplitArray(int[] nums) {
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            left[i] += nums[i];
            left[i] += left[i - 1];

            right[nums.length - i - 1] += nums[nums.length - i - 1];
            right[nums.length - i - 1] += right[nums.length - i - 1 + 1];
        }

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (left[i] >= right[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
