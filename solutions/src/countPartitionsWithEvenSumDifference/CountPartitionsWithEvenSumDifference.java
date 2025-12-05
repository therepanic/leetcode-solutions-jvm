package countPartitionsWithEvenSumDifference;

public class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        int[] postSum = new int[nums.length];
        postSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postSum[i] = postSum[i + 1] + nums[i];
        }
        int c = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            if (Math.abs(sum - postSum[i + 1]) % 2 == 0) {
                c++;
            }
        }
        return c;
    }
}
