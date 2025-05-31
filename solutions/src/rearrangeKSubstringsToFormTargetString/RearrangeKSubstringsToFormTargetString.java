package rearrangeKSubstringsToFormTargetString;

import java.util.HashMap;
import java.util.Map;

public class RearrangeKSubstringsToFormTargetString {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        int window = s.length() / k;
        Map<String, Integer> substringCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i += window) {
            String substr = s.substring(i, i + window);
            substringCountMap.put(substr, substringCountMap.getOrDefault(substr, 0) + 1);
        }
        for (int i = 0; i < t.length(); i += window) {
            String substr = t.substring(i, i + window);
            if (substringCountMap.getOrDefault(substr, 0) == 0) {
                return false;
            }
            substringCountMap.put(substr, substringCountMap.get(substr) - 1);
        }
        return true;
    }

}
