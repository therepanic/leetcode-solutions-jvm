package majorityFrequencyCharacters;

import java.util.*;

public class MajorityFrequencyCharacters {
    public static String majorityFrequencyGroup(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> map2 = new TreeMap<>();
        for (var entry : map.entrySet()) {
            map2.computeIfAbsent(entry.getValue(), p -> new ArrayList<>()).add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        int max = -1;
        for (var entry : map2.entrySet()) {
            if (entry.getValue().size() >= max) {
                max = entry.getValue().size();
                sb.setLength(0);
                for (char c : entry.getValue()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
