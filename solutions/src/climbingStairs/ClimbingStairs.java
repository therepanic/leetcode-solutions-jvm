package climbingStairs;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int sec = 2;

        for (int i = 3; i < n; i++) {
            int secBuffer = sec;

            sec += first;

            first = secBuffer;
        }

        return first + sec;
    }
}
