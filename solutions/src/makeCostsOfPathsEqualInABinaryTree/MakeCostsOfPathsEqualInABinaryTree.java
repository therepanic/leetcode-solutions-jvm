package makeCostsOfPathsEqualInABinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MakeCostsOfPathsEqualInABinaryTree {
    public static void main(String[] args) {
        System.out.println(minIncrements(7, new int[] {1,5,2,2,3,3,1}));
    }
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
