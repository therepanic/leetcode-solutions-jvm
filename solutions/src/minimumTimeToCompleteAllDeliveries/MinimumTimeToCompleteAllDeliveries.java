package minimumTimeToCompleteAllDeliveries;

public class MinimumTimeToCompleteAllDeliveries {
    public long minimumTime(int[] d, int[] r) {
        long left = 0;
        long right = Long.MAX_VALUE;
        long lcm = findLCM(r[0], r[1]);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long a = mid - (mid / r[0]);
            long b = mid - (mid / r[1]);
            long c = mid - (mid / lcm);
            if (a >= d[0] && b >= d[1] && c >= (d[0] + d[1])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public static int findLCM(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / findGCD(a, b);
    }
}
