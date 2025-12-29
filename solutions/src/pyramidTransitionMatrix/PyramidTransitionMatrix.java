package pyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> valMap = new HashMap<>();
        for (int i = 0; i < allowed.size(); i++) {
            String str = allowed.get(i);
            String v = str.substring(str.length() - 1);
            valMap.computeIfAbsent(str.substring(0, str.length() - 1), p -> new ArrayList<>()).add(v);
        }
        return helper(bottom, valMap, 1, "", new HashMap<>());
    }

    public static boolean helper(String platform, Map<String, List<String>> valMap, int i, String s, Map<String, Boolean> cache) {
        if (i == 1) {
            Boolean known = cache.get(platform);
            if (known != null) return known;
        }
        if (i >= platform.length()) {
            if (platform.length() == 1) {
                return true;
            }
            return helper(s, valMap, 1, "", cache);
        }
        for (String part : valMap.getOrDefault(platform.charAt(i - 1) + String.valueOf(platform.charAt(i)), List.of())) {
            if (helper(platform, valMap, i + 1, s + part, cache)) {
                if (i == 1) cache.put(platform, true);
                return true;
            }
        }
        if (i == 1) cache.put(platform, false);
        return false;
    }
}
