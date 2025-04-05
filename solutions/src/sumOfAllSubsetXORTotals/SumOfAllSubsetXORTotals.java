package sumOfAllSubsetXORTotals;

public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        return sum(nums, 0, 0);
    }

    public int sum(int[] nums, int i, int sum) {
        if (i >= nums.length) return sum;
        return sum(nums, i + 1, sum == 0 ? nums[i] : sum ^ nums[i]) + sum(nums, i + 1, sum);
    }
}
