package findTheMaximumFactorScoreOfArray;

public class FindTheMaximumFactorScoreOfArray {
    public long maxScore(int[] nums) {
        if (nums.length == 1) {
            return (long) nums[0] * nums[0];
        }
        long[] posGcd = new long[nums.length];
        long[] negGcd = new long[nums.length];
        long[] posLcm = new long[nums.length];
        long[] negLcm = new long[nums.length];
        posGcd[0] = nums[0];
        posLcm[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            posGcd[i] = gcd(posGcd[i - 1], nums[i]);
            posLcm[i] = lcm(posLcm[i - 1], nums[i]);
        }
        negGcd[negGcd.length - 1] = nums[nums.length - 1];
        negLcm[negLcm.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            negGcd[i] = gcd(negGcd[i + 1], nums[i]);
            negLcm[i] = lcm(negLcm[i + 1], nums[i]);
        }
        long most = posGcd[nums.length - 1] * posLcm[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            long g;
            long l;
            if (i == 0) {
                g = negGcd[1];
                l = negLcm[1];
            } else if (i == nums.length - 1) {
                g = posGcd[nums.length - 2];
                l = posLcm[nums.length - 2];
            } else {
                g = gcd(posGcd[i - 1], negGcd[i + 1]);
                l = lcm(posLcm[i - 1], negLcm[i + 1]);
            }
            most = Math.max(most, g * l);
        }
        return most;
    }

    public static long gcd(final long a, final long b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static long lcm(final long a, final long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs((a / gcd(a, b)) * b);
    }
}
