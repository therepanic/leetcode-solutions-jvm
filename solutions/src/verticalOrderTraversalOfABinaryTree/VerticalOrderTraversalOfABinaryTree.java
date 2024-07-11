package verticalOrderTraversalOfABinaryTree;

import structures.treeNode.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new LinkedHashMap<>();

        helper(root, map, 0, 0);

        List<List<Integer>> verticalTraversal = new LinkedList<>();

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> subVerticalTraversal = new LinkedList<>();

            for (Map.Entry<Integer, List<Integer>> entry1 : entry.getValue().entrySet()) {
                subVerticalTraversal.addAll(entry1.getValue());
            }

            verticalTraversal.add(subVerticalTraversal);
        }

        return verticalTraversal;
    }

    public void helper(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int stage, int x) {
        if (root.left != null) {
            helper(root.left, map, stage + 1, x - 1);
        }

        if (map.containsKey(x)) {
            if (map.get(x).containsKey(stage)) {
                map.get(x).get(stage).add(root.val);
                Collections.sort(map.get(x).get(stage));
            } else {
                map.get(x).put(stage, new ArrayList<>(List.of(root.val)));
            }
        } else {
            map.put(x, new TreeMap<>(Map.of(stage, new ArrayList<>(List.of(root.val)))));
        }

        if (root.right != null) {
            helper(root.right, map, stage + 1, x + 1);
        }
    }
}
