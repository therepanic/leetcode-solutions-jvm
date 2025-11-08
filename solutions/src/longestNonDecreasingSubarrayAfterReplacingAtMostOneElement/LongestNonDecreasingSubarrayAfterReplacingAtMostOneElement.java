package longestNonDecreasingSubarrayAfterReplacingAtMostOneElement;

public class LongestNonDecreasingSubarrayAfterReplacingAtMostOneElement {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int len : left) {
            ans = Math.max(ans, len);
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = Math.max(ans, 1 + (n > 1 ? right[1] : 0));
            } else if (i == n - 1) {
                ans = Math.max(ans, left[n - 2] + 1);
            } else {
                if (nums[i - 1] <= nums[i + 1]) {
                    ans = Math.max(ans, left[i - 1] + 1 + right[i + 1]);
                }
                ans = Math.max(ans, left[i - 1] + 1);
                ans = Math.max(ans, right[i + 1] + 1);
            }
        }

        return Math.min(ans, n);
    }
}
