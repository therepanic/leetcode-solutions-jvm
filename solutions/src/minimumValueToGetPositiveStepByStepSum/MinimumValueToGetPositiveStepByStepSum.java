package minimumValueToGetPositiveStepByStepSum;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int s = 0;
        for (int v : nums) {
            s += v;
            ans = Math.min(s, ans);
        }
        if (ans < 0) {
            return 1 - ans;
        }
        return 1;
    }
}
