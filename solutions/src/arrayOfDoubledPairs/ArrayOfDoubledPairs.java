package arrayOfDoubledPairs;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        for (int x : count.keySet()) {
            if (count.get(x) == 0) {
                continue;
            }
            int need = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(need, 0)) {
                return false;
            }
            count.put(need, count.get(need) - count.get(x));
        }
        return true;
    }
}
