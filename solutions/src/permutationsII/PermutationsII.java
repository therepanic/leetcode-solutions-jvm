package permutationsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            if (numCountMap.containsKey(num)) {
                numCountMap.put(num, numCountMap.get(num) + 1);
            } else {
                numCountMap.put(num, 1);
            }
        }

        List<List<Integer>> permuteUnique = new ArrayList<>();

        helper(permuteUnique, new ArrayList<>(), new HashMap<>(numCountMap), numCountMap, nums.length);

        return permuteUnique;
    }

    public static void helper(List<List<Integer>> permuteUnique, List<Integer> permutation, Map<Integer, Integer> numCountMap, Map<Integer, Integer> copyMap, int numSize) {
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }

            if (numCountMap.containsKey(entry.getKey())) {
                numCountMap.put(entry.getKey(), numCountMap.get(entry.getKey()) - 1);
            }

            permutation.add(entry.getKey());

            helper(permuteUnique, permutation, numCountMap, copyMap, numSize);

            if (permutation.size() == numSize) {
                permuteUnique.add(new ArrayList<>(permutation));
            }

            if (numCountMap.containsKey(entry.getKey())) {
                numCountMap.put(entry.getKey(), numCountMap.get(entry.getKey()) + 1);
            }

            permutation.remove(permutation.size() - 1);
        }
    }
}
