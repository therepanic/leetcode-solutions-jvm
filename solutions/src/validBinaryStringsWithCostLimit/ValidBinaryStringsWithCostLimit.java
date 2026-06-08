package validBinaryStringsWithCostLimit;

import java.util.ArrayList;
import java.util.List;

public class ValidBinaryStringsWithCostLimit {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        helper(sb, false, 0, k, 0, ans);
        return ans;
    }

    public void helper(StringBuilder sb, boolean act, int it, int k, int sum, List<String> ans) {
        if (it == sb.length() && sum <= k) {
            ans.add(sb.toString());
            return;
        }
        if (act) {
            helper(sb, false, it + 1, k, sum, ans);
        } else {
            if (sum + it <= k) {
                StringBuilder ne = new StringBuilder(sb);
                ne.setCharAt(it, '1');
                helper(ne, true, it + 1, k, sum + it, ans);
            }
            helper(sb, false, it + 1, k, sum, ans);
        }
    }
}
