package findAllLonelyNumbersInTheArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> lonely = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() == 1 && !numCountMap.containsKey(entry.getKey() - 1) && !numCountMap.containsKey(entry.getKey() + 1)) {
                lonely.add(entry.getKey());
            }
        }

        return lonely;
    }
}
