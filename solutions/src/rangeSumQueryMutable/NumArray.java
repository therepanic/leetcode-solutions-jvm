package rangeSumQueryMutable;

public class NumArray {
    private final int[] tree;
    private final int n;
    public NumArray(int[] nums) {
        this.tree = new int[4 * nums.length];
        this.n = nums.length - 1;
        build(nums, 1, 0, nums.length - 1);

    }
    private void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(nums, 2 * node, l, mid);
        build(nums, 2 * node + 1, mid + 1, r);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public void update(int index, int val) {
        update(1, 0, n, index, val);
    }

    private void update(int node, int nodeLeft, int nodeRight, int idx, int value) {
        if (nodeLeft == nodeRight) {
            tree[node] = value;
            return;
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        if (idx <= mid) {
            update(2 * node, nodeLeft, mid, idx, value);
        } else {
            update(2 * node + 1, mid + 1, nodeRight, idx, value);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public int sumRange(int left, int right) {
        return query(1, 0, n, left, right);
    }

    private int query(int node, int nodeLeft, int nodeRight, int l, int r) {
        if (nodeRight < l || nodeLeft > r) {
            return 0;
        }
        if (nodeLeft >= l && nodeRight <= r) {
            return tree[node];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftSum = query(2 * node, nodeLeft, mid, l, r);
        int rightSum = query(2 * node + 1, mid + 1, nodeRight, l, r);
        return leftSum + rightSum;
    }
}
