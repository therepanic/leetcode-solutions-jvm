package pairsOfSongsWithTotalDurationsDivisibleBy60;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int num = 0;
        Map<Integer, Integer> numPairMap = new HashMap<>();
        for (int n : time) {
            int r = n % 60;
            int add = (60 - r) % 60;
            num += numPairMap.getOrDefault(r, 0);
            numPairMap.put(add, numPairMap.getOrDefault(add, 0) + 1);
        }
        return num;
    }
}
