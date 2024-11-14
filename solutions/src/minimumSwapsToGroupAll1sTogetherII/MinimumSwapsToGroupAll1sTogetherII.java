package minimumSwapsToGroupAll1sTogetherII;

public class MinimumSwapsToGroupAll1sTogetherII {
        public int minSwaps(int[] nums) {
            int allOneCount = 0;

            for (int num : nums) {
                if (num == 1) allOneCount++;
            }

            int l = 0;
            int r = 0;
            int zeroCount = 0;
            int minZeroCount = Integer.MAX_VALUE;

            while (r < nums.length + allOneCount - 1) {
                if (r < allOneCount) {
                    if (nums[r] == 0) zeroCount++;
                    r++;
                    continue;
                }
                minZeroCount = Math.min(minZeroCount, zeroCount);

                if (nums[l % nums.length] == 0) {
                    zeroCount--;
                }

                l++;

                if (nums[r % nums.length] == 0) {
                    zeroCount++;
                }
                r++;
            }

            minZeroCount = Math.min(minZeroCount, zeroCount);


            return minZeroCount;
        }
}
