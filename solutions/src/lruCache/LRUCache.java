package lruCache;

import java.util.*;

public class LRUCache {
    private Map<Integer, Integer> cache = new LinkedHashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);

            cache.remove(key);
            cache.put(key, value);

            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else {
            if (capacity == 0) {
                cache.remove(cache.entrySet().iterator().next().getKey());

                capacity++;
            }

            capacity--;

            cache.put(key, value);
        }
    }
}
