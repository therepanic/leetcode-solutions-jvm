package minimumAdjacentSwapsToPartitionArray;

public class MinimumAdjacentSwapsToPartitionArray {
    public static int minAdjacentSwaps(int[] nums, int a, int b) {
        Fenwick fenwick = new Fenwick(3);
        long seen = 0;
        long ans = 0;
        for (int x : nums) {
            int comp = x < a ? 0 : (x >= a && x <= b ? 1 : 2);
            ans += seen - fenwick.sum(comp + 1);
            fenwick.add(comp + 1, 1);
            seen++;
        }
        return (int) (ans % 1_000_000_007);
    }

    static class Fenwick {
        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void add(int i, long delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        long sum(int i) {
            long result = 0;

            while (i > 0) {
                result += tree[i];
                i -= i & -i;
            }

            return result;
        }
    }
}
