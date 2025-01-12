package minimizeMaximumOfArray;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        long[] totalSum = new long[nums.length];
        totalSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum[i] = nums[i] + totalSum[i - 1];
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = (int) Math.ceil(Math.max(max, (double) totalSum[i] / (i + 1)));
        }

        return max;
    }
}
