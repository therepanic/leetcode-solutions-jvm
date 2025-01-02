package createBinaryTreeFromDescriptions;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> rootChildrenMap = new HashMap<>();
        int highestRootVal = -1;

        for (int i = 0; i < descriptions.length; i++) {
            if (!rootChildrenMap.containsKey(descriptions[i][0])) {
                rootChildrenMap.put(descriptions[i][0], new int[2]);
            }

            if (descriptions[i][2] == 0) {
                int[] children = rootChildrenMap.get(descriptions[i][0]);

                children[1] = descriptions[i][1];
            } else {
                int[] children = rootChildrenMap.get(descriptions[i][0]);

                children[0] = descriptions[i][1];
            }
        }

        firstLoop: for (int i = 0; i < descriptions.length; i++) {
            int maybeHighestRootVal = descriptions[i][0];

            for (int j = 0; j < descriptions.length; j++) {
                if (descriptions[j][1] == maybeHighestRootVal) {
                    continue firstLoop;
                }
            }

            highestRootVal = maybeHighestRootVal;
            break;
        }

        return helper(highestRootVal, rootChildrenMap);
    }

    public TreeNode helper(int highestRootVal, Map<Integer, int[]> rootChildrenMap) {
        TreeNode newRoot = new TreeNode();

        newRoot.val = highestRootVal;

        if (rootChildrenMap.containsKey(newRoot.val)) {
            int[] children = rootChildrenMap.get(newRoot.val);

            if (children[0] != 0) {
                newRoot.left = helper(children[0], rootChildrenMap);
            }

            if (children[1] != 0) {
                newRoot.right = helper(children[1], rootChildrenMap);
            }
        }

        return newRoot;
    }
}
