package splitAStringIntoTheMaxNumberOfUniqueSubstrings;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        return bypass(s, new HashSet<>());
    }

    private int bypass(String str, Set<String> used) {
        int max = 0;
        for (int i = 1 ; i <= str.length(); i++) {
            String substring = str.substring(0, i);

            if (!used.contains(substring)) {
                used.add(substring);
                max = Math.max(max, 1 + bypass(str.substring(i), used));
                used.remove(substring);
            }
        }

        return max;
    }
}
