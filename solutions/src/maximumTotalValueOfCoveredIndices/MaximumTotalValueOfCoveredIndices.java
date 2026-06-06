package maximumTotalValueOfCoveredIndices;

public class MaximumTotalValueOfCoveredIndices {
    public long maxTotal(int[] nums, String s) {
        long ans = 0;
        int minElement = s.charAt(0) == '1' ? 0 : Integer.MAX_VALUE;
        boolean active = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                active = true;
            } else {
                if (active) {
                    ans -= minElement;
                    minElement = Integer.MAX_VALUE;
                    active = false;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == '1') {
                    ans += nums[i];
                    minElement = Math.min(minElement, nums[i]);
                }
            }
            if (active) {
                ans += nums[i];
                minElement = Math.min(minElement, nums[i]);
            }
        }
        if (active) {
            ans -= minElement;
        }
        return ans;
    }
}
