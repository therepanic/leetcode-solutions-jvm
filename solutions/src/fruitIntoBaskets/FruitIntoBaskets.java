package fruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        int maxLength = 0;
        int l = 0;

        for (int r = 0; r < fruits.length; r++) {
            if (numCountMap.containsKey(fruits[r])) {
                numCountMap.put(fruits[r], numCountMap.get(fruits[r]) + 1);
            } else {
                numCountMap.put(fruits[r], 1);
            }

            while (numCountMap.size() > 2) {
                if (numCountMap.get(fruits[l]) > 1) {
                    numCountMap.put(fruits[l], numCountMap.get(fruits[l]) - 1);
                } else {
                    numCountMap.remove(fruits[l]);
                }

                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
