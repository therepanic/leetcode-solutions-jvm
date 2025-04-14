package maximumSumOfTwoNonOverlappingSubarrays;

public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return Math.max(maxSumTwoNoOverlap1(prefix, firstLen, secondLen), maxSumTwoNoOverlap1(prefix, secondLen, firstLen));
    }

    public int maxSumTwoNoOverlap1(int[] prefix, int firstLen, int secondLen) {
        int maxSum = 0;
        int maxLeft = 0;
        for (int i = firstLen; i <= prefix.length - secondLen - 1; i++) {
            int sumLeft = prefix[i] - prefix[i - firstLen];
            maxLeft = Math.max(maxLeft, sumLeft);
            int sumRight = prefix[i + secondLen] - prefix[i];
            maxSum = Math.max(maxSum, maxLeft + sumRight);
        }
        return maxSum;
    }
}
