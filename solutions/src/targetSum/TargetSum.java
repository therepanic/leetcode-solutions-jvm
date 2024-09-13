package targetSum;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int[] counter = new int[1];

        helper(0, 0, nums, target, counter);

        return counter[0];
    }

    public void helper(int value, int i, int[] nums, int target, int[] counter) {
        if (i >= nums.length && value == target) {
            counter[0]++;
            return;
        }

        if (i >= nums.length) {
            return;
        }

        int curValue = value;

        value += nums[i];

        helper(value, i + 1, nums, target, counter);

        curValue -= nums[i];

        helper(curValue, i + 1, nums, target, counter);
    }
}
