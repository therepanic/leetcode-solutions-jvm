package maximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int val = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > val) {
                val = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }
}
