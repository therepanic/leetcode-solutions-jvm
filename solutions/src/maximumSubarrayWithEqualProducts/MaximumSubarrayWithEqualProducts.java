package maximumSubarrayWithEqualProducts;

public class MaximumSubarrayWithEqualProducts {
    public int maxLength(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            int l = nums[i];
            long prod = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                prod *= nums[j];
                if (prod == (long) g * l) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }
}
