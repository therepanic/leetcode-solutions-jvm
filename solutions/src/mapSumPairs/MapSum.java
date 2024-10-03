package mapSumPairs;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private final Map<String, Integer> core;
    public MapSum() {
        this.core = new HashMap<>();
    }

    public void insert(String key, int val) {
        core.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;

        for (Map.Entry<String, Integer> entry : core.entrySet()) {
            if (entry.getKey().startsWith(prefix)) sum += entry.getValue();
        }

        return sum;
    }
}
