package minimumSwapsToGroupAll1sTogetherII;

public class MinimumSwapsToGroupAll1sTogetherII {
    public int minSwaps(int[] nums) {
        int allOneCount = 0;
        int minZeroCount = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == 1) allOneCount++;
        }

        int l = 0;
        int r = 0;
        int zeroCount = 0;

        while (r < allOneCount) {
            if (nums[r % nums.length] != 1) {
                zeroCount++;
            }
            r++;
        }

        minZeroCount = Math.min(minZeroCount, zeroCount);

        while (r < nums.length + allOneCount - 1) {
            if (nums[l % nums.length] != 1) {
                zeroCount--;
            }

            l++;

            if (nums[r % nums.length] != 1) {
                zeroCount++;
            }
            r++;

            minZeroCount = Math.min(minZeroCount, zeroCount);
        }

        return minZeroCount;
    }
}
