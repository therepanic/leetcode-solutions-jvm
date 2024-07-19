package findDuplicateSubtrees;

import structures.treeNode.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> answer = new LinkedList<>();

        helper(root, answer, new HashMap<>());

        return answer;
    }

    public String helper(TreeNode root, List<TreeNode> answer, Map<String, Integer> serializedTreeCountMap) {
        if (root == null) {
            return "@,";
        }

        String serializedTree = root.val + ",";

        serializedTree += helper(root.left, answer, serializedTreeCountMap);
        serializedTree += helper(root.right, answer, serializedTreeCountMap);

        if (serializedTreeCountMap.containsKey(serializedTree)) {
            serializedTreeCountMap.put(serializedTree, serializedTreeCountMap.get(serializedTree) + 1);
        } else {
            serializedTreeCountMap.put(serializedTree, 1);
        }

        if (serializedTreeCountMap.get(serializedTree) == 2) {
            answer.add(root);
        }

        return serializedTree;
    }

}
