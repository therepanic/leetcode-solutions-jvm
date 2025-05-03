package closestNodesQueriesInABinarySearchTree;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNodesQueriesInABinarySearchTree {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        bypass(root, ans);
        for (int query : queries) {
            int min = min(ans, query);
            int max = max(ans, query);
            int floor = (min >= 0 ? ans.get(min) : -1);
            int ceil  = (max < ans.size() ? ans.get(max) : -1);
            answer.add(List.of(floor, ceil));
        }
        return answer;
    }

    private void bypass(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        bypass(root.left, nums);
        nums.add(root.val);
        bypass(root.right, nums);
    }

    private int min(List<Integer> arr, int target) {
        int idx = Collections.binarySearch(arr, target);
        if (idx >= 0) return idx;
        int ins = -idx - 1;
        return ins - 1;
    }

    private int max(List<Integer> arr, int target) {
        int idx = Collections.binarySearch(arr, target);
        if (idx >= 0) return idx;
        return -idx - 1;
    }
}
