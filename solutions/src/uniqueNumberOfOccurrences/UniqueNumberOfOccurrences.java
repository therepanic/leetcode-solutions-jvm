package uniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : arr) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> ocs = new HashSet<>(numMap.values());
        return ocs.size() == numMap.size();
    }
}
