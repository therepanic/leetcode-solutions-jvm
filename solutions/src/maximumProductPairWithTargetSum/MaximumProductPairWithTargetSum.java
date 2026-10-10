package maximumProductPairWithTargetSum;

public class MaximumProductPairWithTargetSum {
    public int[] maxProductPair(int[] nums, int target) {
        int product = Integer.MIN_VALUE;
        int[] a = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j] && nums[i] + nums[j] == target) {
                    int prod = nums[i] * nums[j];
                    if (prod > product) {
                        product = prod;
                        a = new int[] {i, j};
                    }
                }
            }
        }
        return a;
    }
}
