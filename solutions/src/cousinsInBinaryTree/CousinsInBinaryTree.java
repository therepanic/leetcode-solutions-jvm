package cousinsInBinaryTree;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean[] answer = new boolean[1];

        bypass(root, null, null, x, y, new HashMap<>(), answer);

        return answer[0];
    }

    public void bypass(TreeNode root, TreeNode up, TreeNode upUp, int x, int y, Map<Integer, UpUpUp> map, boolean[] signal) {
        if (root == null || signal[0]) return;

        if (up != null && upUp != null) {
            if (root.val == x || root.val == y) {
                UpUpUp upUpUp = new UpUpUp();
                upUpUp.up = up.val;
                upUpUp.upUp = upUp.val;

                map.put(root.val, upUpUp);
            }

            if (map.size() == 2) {
                int up1 = -1;
                int upUp1 = -1;

                for (UpUpUp upUpUp : map.values()) {
                    if (up1 != upUpUp.up && upUp1 == upUpUp.upUp) {
                        signal[0] = true;
                        return;
                    }
                    up1 = upUpUp.up;
                    upUp1 = upUpUp.upUp;
                }
            }
        }

        bypass(root.left, root, up, x, y, map, signal);
        bypass(root.right, root, up, x, y, map, signal);
    }

    public static class UpUpUp {
        int up;
        Integer upUp;
    }
}
