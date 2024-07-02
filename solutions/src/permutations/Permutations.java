package permutations;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        helper(permutations, nums, new HashSet<>(), new ArrayList<>());

        return permutations;
    }

    public static void helper(List<List<Integer>> permutations, int[] nums, Set<Integer> usedIndexes, List<Integer> subPermutations) {
        if (usedIndexes.size() > nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (usedIndexes.contains(i)) {
                continue;
            }

            subPermutations.add(nums[i]);
            usedIndexes.add(i);

            helper(permutations, nums, usedIndexes, subPermutations);

            if (subPermutations.size() == nums.length && !permutations.contains(subPermutations)) {
                permutations.add(new ArrayList<>(subPermutations));
            }

            usedIndexes.remove(i);
            subPermutations.remove(subPermutations.size() - 1);
        }
    }
}
