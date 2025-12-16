package distinctPointsReachableAfterSubstringRemoval;

import java.util.HashSet;
import java.util.Set;

public class DistinctPointsReachableAfterSubstringRemoval {
    public int distinctPoints(String s, int k) {
        char[] sChars = s.toCharArray();
        int l = 0;
        Set<String> somes = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int r = 0; r < s.length(); r++) {
            if (sChars[l] == 'U' || sChars[l] == 'D') {
                y += del(sChars[r]);
            } else {
                x += del(sChars[r]);
            }
        }
        for (int r = 0; r < s.length(); r++) {
            if (sChars[r] == 'U' || sChars[r] == 'D') {
                y -= del(sChars[r]);
            } else {
                x -= del(sChars[r]);
            }
            if (r - l + 1 > k) {
                if (sChars[l] == 'U' || sChars[l] == 'D') {
                    y += del(sChars[l]);
                } else {
                    x += del(sChars[l]);
                }
                l++;
            }
            if (r - l + 1 == k) {
                somes.add(x + "-" + y);
            }
        }
        return somes.size();
    }

    public int del(char c) {
        if (c == 'U' || c == 'R') {
            return 1;
        } else {
            return -1;
        }
    }
}
