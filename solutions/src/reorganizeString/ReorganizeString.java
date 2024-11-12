package reorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(charCountMap.entrySet());

        Map.Entry<Character, Integer> prev = null;
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            var current = heap.poll();

            sb.append(current.getKey());

            current.setValue(current.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                heap.add(prev);
            }

            prev = current;
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
