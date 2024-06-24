package kthDistinctStringInAnArray;

import java.util.LinkedHashMap;
import java.util.Map;

public class KThDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String str : arr) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (i + 1 == k) {
                    return entry.getKey();
                }
                i++;
            }
        }

        return "";
    }
}
