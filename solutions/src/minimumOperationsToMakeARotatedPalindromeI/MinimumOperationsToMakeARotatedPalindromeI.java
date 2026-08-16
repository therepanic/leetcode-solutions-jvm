package minimumOperationsToMakeARotatedPalindromeI;

public class MinimumOperationsToMakeARotatedPalindromeI {
    public int minOperations(String s) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int c = i;
            for (int j = 0; j < s.length() / 2; j++) {
                int a = s.charAt((i + j) % s.length());
                int b = s.charAt(((i - j - 1) + s.length()) % s.length());
                int d = Math.abs(a - b);
                c += Math.min(d, 26 - d);
                if (c >= ans) {
                    break;
                }
            }
            ans = Math.min(ans, c);
        }
        return ans;
    }
}
