package ransomNote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 1) {
                map.put(c, map.get(c) - 1);
            } else if (map.containsKey(c) && map.get(c) <= 1) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
}
