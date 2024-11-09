package minimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        Set<Integer> freq = new HashSet<>();

        for (int val : charCountMap.values()) {
            while (val > 0 && freq.contains(val)) {
                val--;
                count++;
            }
            freq.add(val);
        }


        return count;
    }
}
