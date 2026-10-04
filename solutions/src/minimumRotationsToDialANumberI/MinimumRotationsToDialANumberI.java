package minimumRotationsToDialANumberI;

public class MinimumRotationsToDialANumberI {
    public int minRotations(String s) {
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            int n = Math.abs(cur - x);
            ans += Math.min(10 - n, n);
            cur = x;
        }
        return ans;
    }
}
