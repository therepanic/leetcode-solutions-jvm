package minimumOperationsToTransformBinaryString;

import java.util.Arrays;

public class MinimumOperationsToTransformBinaryString {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        if (n == 1) {
            if (Arrays.equals(s1Chars, s2Chars)) {
                return 0;
            }
            if (s1Chars[0] == '0' && s2Chars[0] == '1') {
                return 1;
            }
            return -1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s1Chars[i] == '0' && s2Chars[i] == '1') {
                ans++;
            }
        }
        int i = 0;
        while (i < n) {
            if (!(s1Chars[i] == '1' && s2Chars[i] == '0')) {
                i++;
                continue;
            }
            int j = i;
            while (j < n && s1.charAt(j) == '1' && s2Chars[j] == '0') {
                j++;
            }
            int len = j - i;
            ans += len / 2;
            if (len % 2 == 1) {
                ans += 2;
            }
            i = j;
        }
        return ans;
    }
}
