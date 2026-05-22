package countValidWordOccurrences;

import java.util.HashMap;
import java.util.Map;

public class CountValidWordOccurrences {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chunks.length; i++) {
            s.append(chunks[i]);
        }
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (ch == '-' && i > 0 && i < s.length() - 1 && Character.isLetter(s.charAt(i - 1)) && Character.isLetter(s.charAt(i + 1))) {
                sb.append(ch);
            } else {
                if (!sb.isEmpty()) {
                    count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
                    sb.setLength(0);
                }
            }
        }
        if (!sb.isEmpty()) {
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = count.getOrDefault(queries[i], 0);
        }
        return ans;
    }
}
