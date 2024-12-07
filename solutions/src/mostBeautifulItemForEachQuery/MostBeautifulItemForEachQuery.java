package mostBeautifulItemForEachQuery;

import java.util.*;

public class MostBeautifulItemForEachQuery {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> itemMap = new TreeMap<>();

        Arrays.sort(items, Comparator.comparingInt(c -> c[0]));

        int maxPref = items[0][1];

        for (int[] item : items) {
            maxPref = Math.max(item[1], maxPref);

            item[1] = maxPref;

            itemMap.put(item[0], item[1]);
        }

        int[] beauty = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer key = itemMap.floorKey(queries[i]);
            if (key == null) continue;

            beauty[i] = itemMap.get(key);
        }

        return beauty;
    }
}
