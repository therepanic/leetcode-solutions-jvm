package divideAnArrayIntoSubarraysWithMinimumCostI;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minimumCost(int[] nums) {
        int sum = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else {
                min2 = Math.min(min2, nums[i]);
            }
        }
        return sum + min1 + min2;
    }
}
