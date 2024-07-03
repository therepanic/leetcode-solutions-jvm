package combinationSum2;

import java.util.*;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> combinationsSum = new ArrayList<>();

        helper(combinationsSum, new ArrayList<>(), candidates, 0, target);

        return combinationsSum;
    }

    public static void helper(List<List<Integer>> combinations, List<Integer> subCombinations, int[] candidates, int startIndex, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            combinations.add(new ArrayList<>(subCombinations));
        }

        int prev = -1;

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] == prev) {
                continue;
            }

            subCombinations.add(candidates[i]);

            helper(combinations, subCombinations, candidates, i + 1, target - candidates[i]);

            subCombinations.remove(subCombinations.size() - 1);

            prev = candidates[i];
        }
    }
}
