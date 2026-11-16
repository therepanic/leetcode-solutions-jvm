package largestNumberAtLeastTwiceOfOthers;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int a = -1;
        int it = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                a = nums[i];
                it = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != it && nums[i] * 2 > a) {
                return -1;
            }
        }
        return it;
    }
}
