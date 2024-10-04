package insertDeleteGetRandomO1;

import java.util.*;

public class RandomizedSet {
    private final Map<Integer, Integer> valueIndexMap;
    private final List<Integer> indexList;
    private final Random random;

    public RandomizedSet() {
        this.valueIndexMap = new HashMap<>();
        this.indexList = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) return false;

        valueIndexMap.put(val, indexList.size());
        indexList.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean isPresent = valueIndexMap.containsKey(val);

        if (!isPresent) {
            return false;
        } else {
            int index = valueIndexMap.get(val);

            int lastVal = indexList.getLast();

            indexList.set(index, lastVal);

            valueIndexMap.put(lastVal, index);

            valueIndexMap.remove(val);
            indexList.removeLast();

            return true;
        }
    }

    public int getRandom() {
        return indexList.get(random.nextInt(indexList.size()));
    }
}
