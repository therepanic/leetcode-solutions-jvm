package combinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationSums = new ArrayList<>();

        helper(combinationSums, candidates, target, new ArrayList<>(), 0, 0);

        return combinationSums;
    }

    public static void helper(List<List<Integer>> combinationsSum, int[] candidates, int target, List<Integer> combinations, int sum, int startingIndex) {
        if (sum > target) {
            return;
        }

        for (int i = startingIndex; i < candidates.length; i++) {
            combinations.add(candidates[i]);

            helper(combinationsSum, candidates, target, combinations, sum + candidates[i], i);

            if (sum == target) {
                combinations.remove(combinations.size() - 1);
                combinationsSum.add(new ArrayList<>(combinations));
                break;
            }

            combinations.remove(combinations.size() - 1);
        }
    }
}
