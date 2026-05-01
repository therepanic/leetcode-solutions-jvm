package xORQueriesOfASubarray;

public class XORQueriesOfASubarray {

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            for (++i; i <= n; i += i & -i)
                tree[i] ^= val;
        }

        int prefix(int i) {
            int res = 0;
            for (++i; i > 0; i -= i & -i)
                res ^= tree[i];
            return res;
        }

        int query(int l, int r) {
            return prefix(r) ^ (l > 0 ? prefix(l - 1) : 0);
        }
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        Fenwick fenwick = new Fenwick(arr.length);
        for (int i = 0; i < arr.length; i++) {
            fenwick.update(i, arr[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = fenwick.query(queries[i][0], queries[i][1]);
        }
        return ans;
    }
}
