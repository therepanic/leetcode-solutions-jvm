package permutationDifferenceBetweenTwoStrings;

import java.util.Arrays;

public class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        int[] a = new int[26];
        Arrays.fill(a, -1);
        int[] b = new int[26];
        Arrays.fill(b, -1);
        for (int i = 0; i < s.length(); i++) {
            int ach = s.charAt(i) - 'a';
            int tch = t.charAt(i) - 'a';
            if (a[ach] == -1) {
                a[ach] = i;
            }
            if (b[tch] == -1) {
                b[tch] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans += Math.abs(a[ch - 'a'] - b[ch - 'a']);
        }
        return ans;
    }
}
