package maximumDepthOfNaryTree;

import structures.nTreeNode.NTreeNode;

public class MaximumDepthOfNaryTree {
    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;

        for (NTreeNode node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }

        depth++;

        return depth;
    }
}
