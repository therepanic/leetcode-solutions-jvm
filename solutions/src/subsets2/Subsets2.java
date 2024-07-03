package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetsWithDup = new ArrayList<>();

        helper(subsetsWithDup, new ArrayList<>(), nums, 0);

        return subsetsWithDup;
    }

    public static void helper(List<List<Integer>> subsetsWithDup, List<Integer> subSubsetsWithDup, int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            if (!subsetsWithDup.contains(subSubsetsWithDup)) {
                subsetsWithDup.add(new ArrayList<>(subSubsetsWithDup));
            }
            return;
        }

        subSubsetsWithDup.add(nums[startIndex]);

        helper(subsetsWithDup, new ArrayList<>(subSubsetsWithDup), nums, startIndex + 1);

        subSubsetsWithDup.remove(subSubsetsWithDup.size() - 1);

        helper(subsetsWithDup, new ArrayList<>(subSubsetsWithDup), nums, startIndex + 1);
    }
}
