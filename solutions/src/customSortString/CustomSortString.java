package customSortString;

import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(String.valueOf(c).repeat(map.get(c)));
            }

            map.remove(c);
        }

        if (map.isEmpty()) {
            return sb.toString();
        }

        for (char c : map.keySet()) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }

        return sb.toString();
    }
}
