package maximumSumWithExactlyKElements;

public class MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        int max = -1;
        for (int v: nums) {
            max = Math.max(max, v);
        }
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += max;
            max++;
        }
        return s;
    }
}
