package partitionArrayIntoDisjointIntervals;

public class PartitionArrayIntoDisjointIntervals {
    public static int partitionDisjoint(int[] nums) {
        int curMax = nums[0];
        int posMax = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < curMax) {
                len = i + 1;
                curMax = posMax;
            } else {
                posMax = Math.max(posMax, nums[i]);
            }
        }
        return len;
    }
}
