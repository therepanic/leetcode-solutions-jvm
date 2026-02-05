package transformedArray;

public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v != 0) {
                int idx = ((i + v) % nums.length + nums.length) % nums.length;
                ans[i] = nums[idx];
            }
        }
        return ans;
    }
}
