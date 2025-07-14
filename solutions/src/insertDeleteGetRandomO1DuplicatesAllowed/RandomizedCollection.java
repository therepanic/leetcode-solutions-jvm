package insertDeleteGetRandomO1DuplicatesAllowed;

import java.util.*;

public class RandomizedCollection {
    private final Map<Integer, Set<Integer>> valueIndexMap;
    private final List<Integer> indexList;
    private final Random random;
    public RandomizedCollection() {
        this.valueIndexMap = new HashMap<>();
        this.indexList = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        boolean hasNot = !valueIndexMap.containsKey(val);

        valueIndexMap.computeIfAbsent(val, p -> new HashSet<>()).add(indexList.size());
        indexList.add(val);
        return hasNot;
    }

    public boolean remove(int val) {
        boolean isPresent = valueIndexMap.containsKey(val);

        if (!isPresent) {
            return false;
        } else {
            int indexToRemove = valueIndexMap.get(val).iterator().next();
            valueIndexMap.get(val).remove(indexToRemove);

            int lastIndex = indexList.size() - 1;
            int lastVal = indexList.get(lastIndex);

            if (indexToRemove != lastIndex) {
                indexList.set(indexToRemove, lastVal);

                Set<Integer> lastValIndices = valueIndexMap.get(lastVal);
                lastValIndices.remove(lastIndex);
                lastValIndices.add(indexToRemove);
            }

            indexList.remove(lastIndex);

            if (valueIndexMap.get(val).isEmpty()) {
                valueIndexMap.remove(val);
            }
            return true;
        }
    }

    public int getRandom() {
        return indexList.get(random.nextInt(indexList.size()));
    }
}
