package timeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            map.put(key, new TreeMap<>(Map.of(timestamp, value)));
        }
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Integer floorKey = map.get(key).floorKey(timestamp);

        return floorKey == null ? "" : map.get(key).get(floorKey);
    }
}
