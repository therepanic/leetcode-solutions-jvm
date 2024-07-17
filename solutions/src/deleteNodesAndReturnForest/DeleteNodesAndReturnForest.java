package deleteNodesAndReturnForest;

import structures.treeNode.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();

        for (int num : to_delete) {
            set.add(num);
        }

        Map<Integer, TreeNode> map = new HashMap<>();

        helper(root, set, map);

        return new ArrayList<>(map.values());
    }

    public TreeNode helper(TreeNode root, Set<Integer> toDelete, Map<Integer, TreeNode> map) {
        if (root.left != null) {
            root.left = helper(root.left, toDelete, map);
        }

        if (root.right != null) {
            root.right = helper(root.right, toDelete, map);
        }

        boolean isToDelete = toDelete.contains(root.val);

        if (!isToDelete && root.left != null && !toDelete.contains(root.left.val)) {
            map.remove(root.left.val);
        }

        if (!isToDelete && root.right != null && !toDelete.contains(root.right.val)) {
            map.remove(root.right.val);
        }

        if (isToDelete) {
            return null;
        } else {
            map.put(root.val, root);
            return root;
        }
    }

}
