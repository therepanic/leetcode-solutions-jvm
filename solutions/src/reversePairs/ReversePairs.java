package reversePairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        long[] preCompressed = new long[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            preCompressed[i] = nums[i];
            preCompressed[i + nums.length] = 2L * nums[i];
        }
        long[] compressed = Arrays.stream(preCompressed).distinct().toArray();
        Arrays.sort(compressed);
        Map<Long, Integer> compressedMap = new HashMap<>();
        for (int i = 0, c = 1; i < compressed.length; i++) {
            if (!compressedMap.containsKey(compressed[i])) {
                compressedMap.put(compressed[i], c);
                c++;
            }
        }
        Fenwick fenwick = new Fenwick(compressed.length);
        int c = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int id = compressedMap.get((long) nums[i]);
            c += fenwick.sum(id - 1);
            fenwick.add(compressedMap.get((long) nums[i] * 2), 1);
        }
        return c;
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
