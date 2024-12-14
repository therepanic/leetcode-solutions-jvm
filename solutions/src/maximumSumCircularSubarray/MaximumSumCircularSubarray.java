package maximumSumCircularSubarray;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[] {5,-3,5}));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int maxSoFar = nums[0];
        int max = nums[0];

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);

            max = Math.max(maxSoFar, max);

            sum += nums[i];
        }

        int minSoFar = nums[0];
        int min = nums[0];


        for (int i = 1; i < nums.length; i++) {
            minSoFar = Math.min(minSoFar + nums[i], nums[i]);

            min = Math.min(minSoFar, min);
        }

        if (sum == min) return max;

        return Math.max(max, sum - min);
    }
}
