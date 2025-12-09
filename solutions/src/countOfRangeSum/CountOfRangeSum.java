package countOfRangeSum;

import java.util.*;

public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> values = new HashSet<>(Set.of(0L));
        for (int val : nums) {
            values.add((long) val);
        }
        long[] pref = new long[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < pref.length; i++) {
            pref[i] = nums[i] + pref[i - 1];
        }
        for (int i = 0; i < pref.length; i++) {
            values.add(pref[i]);
            values.add(pref[i] - lower);
            values.add(pref[i] - upper);
        }
        long[] compressed = new long[values.size()];
        int it = 0;
        for (long val : values) {
            compressed[it] = val;
            it++;
        }
        Arrays.sort(compressed);
        Map<Long, Integer> compressedMap = new HashMap<>();
        for (int i = 0, color = 1; i < compressed.length; i++) {
            compressedMap.put(compressed[i], color);
            color++;
        }
        int count = 0;
        Fenwick fw = new Fenwick(compressed.length);
        fw.add(compressedMap.get(0L), 1);
        for (int i = 0; i < pref.length; i++) {
            int upperVal = compressedMap.get(pref[i] - lower);
            int lowerVal = compressedMap.get(pref[i] - upper);
            count += fw.rangeSum(lowerVal, upperVal);
            fw.add(compressedMap.get(pref[i]), 1);
        }
        return count;
    }

    public static class Fenwick {

        private final int n;

        private final int[] tree;


        public Fenwick(int n) {

            this.n = n;

            this.tree = new int[n + 1];

        }


        public void add(int index, int value) {

            for (; index <= n; index += index & -index) {

                tree[index] += value;

            }

        }


        public int sum(int index) {

            int result = 0;

            for (; index > 0; index -= index & -index) {

                result += tree[index];

            }

            return result;

        }


        public int rangeSum(int l, int r) {

            return sum(r) - sum(l - 1);

        }

    }
}
