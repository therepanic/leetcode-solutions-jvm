package maximumDifferenceBetweenAdjacentElementsInACircularArray;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int prev = i - 1;
            if (prev == -1) {
                prev = nums.length - 1;
            }
            max = Math.max(max, Math.abs(nums[i] - nums[prev]));
        }
        return max;
    }
}
