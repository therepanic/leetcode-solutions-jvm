package countDominantIndices;

public class CountDominantIndices {
    public int dominantIndices(int[] nums) {
        double[] avg = new double[nums.length];
        int a = 0;
        int c = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            a += nums[i];
            c++;
            avg[i] = (double) a / c;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > avg[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}
