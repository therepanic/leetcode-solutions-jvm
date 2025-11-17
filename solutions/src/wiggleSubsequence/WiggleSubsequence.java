package wiggleSubsequence;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int u = 1, d = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                u = d + 1;
            } else if (nums[i] < nums[i + 1]) {
                d = u + 1;
            }
        }
        return Math.max(d, u);
    }
}
