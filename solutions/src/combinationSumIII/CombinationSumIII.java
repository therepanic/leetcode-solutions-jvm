package combinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinationSum = new ArrayList<>();

        helper(combinationSum, new ArrayList<>(), 1, 1, 0, k, n);

        return combinationSum;
    }

    public static void helper(List<List<Integer>> combinationSum, List<Integer> currentCombinationSum, int start, int currentK, int currentN, int k, int n) {
        if (currentK > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (currentN + i > n) {
                break;
            }

            currentCombinationSum.add(i);

            if (currentK == k && currentN + i == n) {
                combinationSum.add(new ArrayList<>(currentCombinationSum));
            }

            helper(combinationSum, currentCombinationSum, i + 1, currentK + 1, currentN + i, k, n);

            currentCombinationSum.remove(currentCombinationSum.size() - 1);
        }
    }
}
