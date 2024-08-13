package maximumAbsoluteSumOfAnySubarray;

public class MaximumAbsoluteSumOfAnySubarray {
    public static int maxAbsoluteSum(int[] nums) {
        int maxAbsoluteSum = 0;

        int lowestSum = 0;
        int highestSum = 0;

        for (int num : nums) {
            highestSum = Math.max(highestSum + num, num);

            lowestSum = Math.min(lowestSum + num, num);

            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.abs(highestSum));
            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.abs(lowestSum));
        }

        return maxAbsoluteSum;
    }
}
