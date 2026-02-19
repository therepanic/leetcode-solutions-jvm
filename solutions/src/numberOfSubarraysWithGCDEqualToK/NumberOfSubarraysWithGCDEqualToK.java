package numberOfSubarraysWithGCDEqualToK;

public class NumberOfSubarraysWithGCDEqualToK {
    public int subarrayGCD(int[] nums, int k) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (d == k) {
                c++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                d = gcd(d, nums[j]);
                if (d == k) {
                    c++;
                }
            }
        }
        return c;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
