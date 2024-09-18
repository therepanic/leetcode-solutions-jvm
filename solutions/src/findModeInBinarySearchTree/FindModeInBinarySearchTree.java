package findModeInBinarySearchTree;

import structures.treeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();

        bypass(root, countMap);

        int maxValue = Integer.MIN_VALUE;
        int maxValueCount = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxValueCount = 1;
            } else if (entry.getValue() == maxValue){
                maxValueCount++;
            }
        }

        int[] answer = new int[maxValueCount];

        int i = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                answer[i] = entry.getKey();
                i++;
            }
        }

        return answer;
    }

    public void bypass(TreeNode root, Map<Integer, Integer> countMap) {
        if (root == null) return;

        if (countMap.containsKey(root.val)) {
            countMap.put(root.val, countMap.get(root.val) + 1);
        } else {
            countMap.put(root.val, 1);
        }

        bypass(root.left, countMap);
        bypass(root.right, countMap);
    }
}
