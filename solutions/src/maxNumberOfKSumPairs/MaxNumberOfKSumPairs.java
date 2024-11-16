package maxNumberOfKSumPairs;

public class MaxNumberOfKSumPairs {
    public int minSwaps(int[] nums) {
        int allOneCount = 0;
        int minZeroCount = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == 1) allOneCount++;
        }

        int l = 0;
        int r = 0;
        int oneCount = 0;
        int zeroCount = 0;

        while (r < allOneCount) {
            if (nums[r % nums.length] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
            r++;
        }

        minZeroCount = Math.min(minZeroCount, zeroCount);

        while (r < nums.length + allOneCount - 1) {
            if (nums[l % nums.length] == 1) {
                oneCount--;
            } else {
                zeroCount--;
            }
            l++;

            if (nums[r % nums.length] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
            r++;

            minZeroCount = Math.min(minZeroCount, zeroCount);
        }

        return minZeroCount;
    }
}
