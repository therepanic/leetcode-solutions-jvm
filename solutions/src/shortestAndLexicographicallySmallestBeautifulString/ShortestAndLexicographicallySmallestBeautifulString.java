package shortestAndLexicographicallySmallestBeautifulString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestAndLexicographicallySmallestBeautifulString {

    public String shortestBeautifulSubstring(String s, int k) {
        char[] sChars = s.toCharArray();
        int minSize = Integer.MAX_VALUE;
        List<String> all = new ArrayList<>();
        int c = 0;
        int l = 0;
        for (int r = 0; r < sChars.length; r++) {
            if (sChars[r] == '1') {
                c++;
            }
            while (c > k || sChars[l] == '0' && l < r) {
                if (sChars[l] == '1') {
                    c--;
                }
                l++;
            }
            if (c == k && r - l + 1 < minSize) {
                minSize = r - l + 1;
                all.clear();
                all.add(s.substring(l, r + 1));
            } else if (c == k && r - l + 1 == minSize) {
                all.add(s.substring(l, r + 1));
            }
        }
        Collections.sort(all);
        return all.isEmpty() ? "" : all.getFirst();
    }

}
