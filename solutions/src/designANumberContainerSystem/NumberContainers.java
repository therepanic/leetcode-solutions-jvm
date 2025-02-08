package designANumberContainerSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NumberContainers {
    private final Map<Integer, Integer> indexNumberMap;
    private final Map<Integer, TreeSet<Integer>> numberIndexesMap;

    public NumberContainers() {
        this.indexNumberMap = new HashMap<>();
        this.numberIndexesMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexNumberMap.containsKey(index)) {
            int num = indexNumberMap.get(index);
            numberIndexesMap.get(num).remove(index);
        }
        indexNumberMap.put(index, number);
        if (numberIndexesMap.containsKey(number)) {
            numberIndexesMap.get(number).add(index);
        } else {
            numberIndexesMap.put(number, new TreeSet<>(Set.of(index)));
        }
    }

    public int find(int number) {
        if (numberIndexesMap.containsKey(number) && !numberIndexesMap.get(number).isEmpty()) {
            return numberIndexesMap.get(number).getFirst();
        } else {
            return -1;
        }
    }

}
