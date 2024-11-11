package handOfStraights;

import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> numCountMap = new TreeMap<>();

        for (int num : hand) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numCountMap.keySet()) {
            int count = numCountMap.get(num);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int nextNum = num + i;
                    int nextCount = numCountMap.getOrDefault(nextNum, 0);
                    if (nextCount < count) {
                        return false;
                    }
                    numCountMap.put(nextNum, nextCount - count);
                }
            }
        }

        return true;
    }
}
