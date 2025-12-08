package countOfSmallerNumbersAfterSelf;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int[] compressed = Arrays.stream(nums.clone()).distinct().toArray();
        Arrays.sort(compressed);
        Map<Integer, Integer> compressedMap = new HashMap<>();
        for (int i = 0, c = 1; i < compressed.length; i++) {
            if (!compressedMap.containsKey(compressed[i])) {
                compressedMap.put(compressed[i], c);
                c++;
            }
        }
        Fenwick fenwick = new Fenwick(compressed.length);
        List<Integer> ans = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            ans.add(0);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int id = compressedMap.get(nums[i]);
            fenwick.add(id, 1);
            ans.set(i, fenwick.sum(id - 1));
        }
        return ans;
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
