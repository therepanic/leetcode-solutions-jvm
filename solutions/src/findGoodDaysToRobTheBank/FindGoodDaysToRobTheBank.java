package findGoodDaysToRobTheBank;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        boolean[] left = new boolean[n];
        int len = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && security[i - 1] >= security[i]) {
                len++;
            } else {
                len = 1;
            }

            if (len >= time + 1) {
                left[i] = true;
            }
        }
        boolean[] right = new boolean[n];
        len = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && security[i] <= security[i + 1]) {
                len++;
            } else {
                len = 1;
            }

            if (len >= time + 1) {
                right[i] = true;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] && right[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
