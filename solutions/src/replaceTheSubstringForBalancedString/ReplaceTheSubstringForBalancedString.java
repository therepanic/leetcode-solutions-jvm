package replaceTheSubstringForBalancedString;

public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int[] c = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            c[chars[i]]++;
        }
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int k = chars.length / 4;
        for (int r = 0; r < chars.length; r++) {
            c[chars[r]]--;
            while (l < chars.length && c['Q'] <= k && c['W'] <= k && c['E'] <= k && c['R'] <= k) {
                ans = Math.min(ans, r - l + 1);
                c[chars[l]]++;
                l++;
            }
        }
        return ans;
    }
}
