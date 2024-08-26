package mostFrequentSubtreeSum;

import structures.treeNode.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFrequentMap = new LinkedHashMap<>();

        helper(root, sumFrequentMap);

        int maxFrequent = Integer.MIN_VALUE;
        int maxFrequentCounts = 0;

        for (int frequent : sumFrequentMap.values()) {
            if (maxFrequent < frequent) {
                maxFrequentCounts = 1;
                maxFrequent = frequent;
            } else if (maxFrequent == frequent){
                maxFrequentCounts++;
            }
        }

        int[] frequentTreeSum = new int[maxFrequentCounts];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : sumFrequentMap.entrySet()) {
            if (entry.getValue().equals(maxFrequent)) {
                frequentTreeSum[i] = entry.getKey();
                i++;
            }
        }

        return frequentTreeSum;
    }

    public int helper(TreeNode root, Map<Integer, Integer> sumFrequentMap) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, sumFrequentMap);
        int right = helper(root.right, sumFrequentMap);

        int current = left + right + root.val;

        if (sumFrequentMap.containsKey(current)) {
            sumFrequentMap.put(current, sumFrequentMap.get(current) + 1);
        } else {
            sumFrequentMap.put(current, 1);
        }

        return current;
    }
}
