package findingPairsWithACertainSum;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private final int[] nums2;
    private final Map<Integer, Integer> countMap1;
    private final Map<Integer, Integer> countMap2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        this.countMap1 = new HashMap<>();
        for (int num : nums1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }
        this.countMap2 = new HashMap<>();
        for (int num : nums2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int old = nums2[index];
        nums2[index] += val;
        countMap2.put(old, countMap2.getOrDefault(old, 0) - 1);
        countMap2.put(old + val, countMap2.getOrDefault(old + val, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        Map<Integer, Integer> smallest = countMap1.size() >= countMap2.size() ? countMap2 : countMap1;
        Map<Integer, Integer> largest = countMap1.size() < countMap2.size() ? countMap2 : countMap1;
        for (Map.Entry<Integer, Integer> entry : smallest.entrySet()) {
            int need = tot - entry.getKey();
            count += entry.getValue() * largest.getOrDefault(need, 0);
        }
        return count;
    }
}
