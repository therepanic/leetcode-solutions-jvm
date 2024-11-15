package countSubarraysWhereMaxElementAppearsAtLeastKTimes;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) maxNum = Math.max(maxNum, num);

        long maxCount = 0;

        int l = 0;
        int maxNumCount = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == maxNum) maxNumCount++;

            while (maxNumCount >= k) {
                maxCount += nums.length - r;

                if (nums[l] == maxNum) maxNumCount--;
                l++;
            }
        }

        return maxCount;
    }
}
