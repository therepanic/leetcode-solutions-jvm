package minimumRangeAfterSumOperations;

public class MinimumRangeAfterSumOperations {
    public int minRange(int a, int b, int c) {
        int ans = Integer.MAX_VALUE;
        int sumA = b + c;
        ans = Math.min(ans, Math.max(b, Math.max(c, sumA)) - Math.min(b, Math.min(c, sumA)));
        int sumB = a + c;
        ans = Math.min(ans, Math.max(a, Math.max(c, sumB)) - Math.min(a, Math.min(c, sumB)));
        int sumC = a + b;
        ans = Math.min(ans, Math.max(a, Math.max(b, sumC)) - Math.min(a, Math.min(b, sumC)));
        ans = Math.min(ans, Math.max(b, Math.max(c, a)) - Math.min(b, Math.min(c, a)));
        return ans;
    }
}
