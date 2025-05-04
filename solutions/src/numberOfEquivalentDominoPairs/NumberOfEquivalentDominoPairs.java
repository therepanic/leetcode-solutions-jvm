package numberOfEquivalentDominoPairs;

import java.util.*;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<List<Integer>, Integer> countMap = new HashMap<>();
        int count = 0;
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            List<Integer> key = List.of(domino[0], domino[1]);
            count += countMap.getOrDefault(key, 0);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        return count;
    }
}
