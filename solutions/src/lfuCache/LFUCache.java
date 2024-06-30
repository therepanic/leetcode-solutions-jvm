package lfuCache;

import java.util.*;

public class LFUCache {
    private static class InternalCache {
        public InternalCache(int value, int frequent) {
            this.value = value;
            this.frequent = frequent;
        }
        public int value;
        public int frequent;
    }

    private final Map<Integer, InternalCache> keyToInternalCacheMap = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> frequentToKeysMap = new TreeMap<>();

    private int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToInternalCacheMap.containsKey(key)) {
            InternalCache gettedInternalCache = keyToInternalCacheMap.get(key);

            updateFrequent(gettedInternalCache, key, gettedInternalCache.frequent + 1);

            return gettedInternalCache.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyToInternalCacheMap.containsKey(key)) {
            InternalCache variableInternalCache = keyToInternalCacheMap.get(key);

            updateFrequent(variableInternalCache, key, variableInternalCache.frequent + 1);

            variableInternalCache.value = value;
        } else {
            if (capacity == 0) {
                int frequentToKeysKeyForRemove = frequentToKeysMap.entrySet().iterator().next().getKey();

                int keyToInternalCacheKeyForRemove = frequentToKeysMap.get(frequentToKeysKeyForRemove).iterator().next();

                frequentToKeysMap.get(frequentToKeysKeyForRemove).remove(keyToInternalCacheKeyForRemove);

                if (frequentToKeysMap.get(frequentToKeysKeyForRemove).isEmpty()) {
                    frequentToKeysMap.remove(frequentToKeysKeyForRemove);
                }

                keyToInternalCacheMap.remove(keyToInternalCacheKeyForRemove);
            } else {
                capacity--;
            }

            InternalCache newInternalCache = new InternalCache(value, 1);

            if (frequentToKeysMap.containsKey(newInternalCache.frequent)) {
                frequentToKeysMap.get(newInternalCache.frequent).add(key);
            } else {
                frequentToKeysMap.put(newInternalCache.frequent, new LinkedHashSet<>(Set.of(key)));
            }

            keyToInternalCacheMap.put(key, newInternalCache);
        }
    }

    private void updateFrequent(InternalCache internalCache, int key, int frequent) {
        frequentToKeysMap.get(internalCache.frequent).remove(key);

        if (frequentToKeysMap.get(internalCache.frequent).isEmpty()) {
            frequentToKeysMap.remove(internalCache.frequent);
        }

        internalCache.frequent = frequent;

        if (frequentToKeysMap.containsKey(frequent)) {
            frequentToKeysMap.get(frequent).add(key);
        } else {
            frequentToKeysMap.put(frequent, new LinkedHashSet<>(Set.of(key)));
        }
    }
}
