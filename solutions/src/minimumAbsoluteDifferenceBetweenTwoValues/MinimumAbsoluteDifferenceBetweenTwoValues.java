package minimumAbsoluteDifferenceBetweenTwoValues;

public class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        int c = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == 1 && nums[j] == 2) {
                    c = Math.min(c, Math.abs(i - j));
                }
            }
        }
        return c == Integer.MAX_VALUE ? -1 : c;
    }
}
