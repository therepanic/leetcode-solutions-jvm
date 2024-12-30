package makeCostsOfPathsEqualInABinaryTree;

public class MakeCostsOfPathsEqualInABinaryTree {
    public static int minIncrements(int n, int[] cost) {
        int[] sum = new int[1];
        helper(0, cost, sum);
        return sum[0];
    }

    public static int helper(int i, int[] cost, int[] sum) {
        if (i >= cost.length) return 0;

        int first = helper(i * 2 + 1, cost, sum);
        int second = helper(i * 2 + 2, cost, sum);

        sum[0] += Math.abs(first - second);

        return cost[i] + Math.max(first, second);
    }
}
