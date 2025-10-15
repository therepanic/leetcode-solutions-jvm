package intervalsBetweenIdenticalElements;

import java.util.HashMap;
import java.util.Map;

public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        Map<Integer, Long> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();
        long[] all = new long[arr.length];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            all[i] += count.getOrDefault(arr[i], 0L) * c - sum.getOrDefault(arr[i], 0L);
            sum.put(arr[i], sum.getOrDefault(arr[i], 0L) + c);
            count.put(arr[i], count.getOrDefault(arr[i], 0L) + 1);
            c++;
        }
        count.clear();
        sum.clear();
        c = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            all[i] += count.getOrDefault(arr[i], 0L) * c - sum.getOrDefault(arr[i], 0L);
            sum.put(arr[i], sum.getOrDefault(arr[i], 0L) + c);
            count.put(arr[i], count.getOrDefault(arr[i], 0L) + 1);
            c++;
        }
        return all;
    }
}
