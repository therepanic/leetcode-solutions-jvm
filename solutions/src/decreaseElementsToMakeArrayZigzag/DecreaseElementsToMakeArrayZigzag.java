package decreaseElementsToMakeArrayZigzag;

public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int minC;
        int curC = 0;
        for (int i = 1; i < nums.length; i += 2) {
            int def = nums[i];
            if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                curC += nums[i] - nums[i - 1] + 1;
                nums[i] = nums[i - 1] - 1;
            }
            if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                curC += nums[i] - nums[i + 1] + 1;
            }
            nums[i] = def;
        }
        minC = curC;
        curC = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int def = nums[i];
            if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                curC += nums[i] - nums[i - 1] + 1;
                nums[i] = nums[i - 1] - 1;
            }
            if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                curC += nums[i] - nums[i + 1] + 1;
            }
            nums[i] = def;
        }
        minC = Math.min(curC, minC);
        return minC;
    }
}
