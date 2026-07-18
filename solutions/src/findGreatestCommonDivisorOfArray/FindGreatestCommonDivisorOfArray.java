package findGreatestCommonDivisorOfArray;

public class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            a = Math.min(nums[i], a);
            b = Math.max(nums[i], b);
        }
        return gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
