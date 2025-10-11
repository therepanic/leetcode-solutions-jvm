package longestFibonacciSubarray;

public class LongestFibonacciSubarray {
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int ans = 2;
        int curr = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                curr++;
            } else {
                curr = 2;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
