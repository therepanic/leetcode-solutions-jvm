package mostCommonWord;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] b) {
        Set<String> banned = new HashSet<>();
        for (String s : b) {
            banned.add(s.toLowerCase());
        }
        String[] split = paragraph.split("[!?',;.\\s]+");
        Map<String, Integer> count = new HashMap<>();
        for (String s : split) {
            String a = s.toLowerCase();;
            if (banned.contains(a)) continue;
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String v = null;
        for (var entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                v = entry.getKey();
            }
        }
        return v;
    }
}
