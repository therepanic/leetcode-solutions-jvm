package checkIfAStringContainsAllBinaryCodesOfSizeK;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int l = 0;
        Set<String> strs = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            if (r - l + 1 > k) {
                l++;
            } else if (r - l + 1 < k) {
                continue;
            }
            strs.add(s.substring(l, r + 1));
        }
        return strs.size() == ((int) Math.pow(2, k));
    }
}
