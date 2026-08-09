package weightedSumOfATree;

import java.util.ArrayList;
import java.util.List;

public class WeightedSumOfATree {
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                tree.get(parent[i]).add(i);
            }
        }
        int height = height(0,tree, 1);
        return helper(0, nums, 1, height, tree);
    }

    public long helper(int node, int[] nums, int depth, int height, List<List<Integer>> tree) {
        long sum = (long) nums[node] * (height - depth + 1);
        for (int v : tree.get(node)) {
            sum += helper(v, nums, depth + 1, height, tree);
        }
        return sum;
    }

    public int height(int node, List<List<Integer>> tree, int height) {
        int max = height;
        for (int v : tree.get(node)) {
            max = Math.max(max, height(v, tree, height + 1));
        }
        return max;
    }
}
