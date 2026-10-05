package minimumRotationsToDialANumberII;

public class MinimumRotationsToDialANumberII {
    public int minRotations(int A, String s) {
        int last = s.charAt(s.length() - 1) - '0';
        int cur = last;
        int[] suf = new int[s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            suf[i] += s(cur, x) + suf[i + 1];
            cur = x;
        }
        int ans = 0;
        int rl = Integer.MAX_VALUE;
        cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            rl = Math.min(rl, i == A - 1 ? Integer.MAX_VALUE : ans + suf[i] + s(last, cur));
            ans += s(cur, x);
            cur = x;
        }
        return Math.min(ans, rl);
    }

    public int s(int a, int b) {
        int n = Math.abs(a - b);
        return Math.min(10 - n, n);
    }
}
