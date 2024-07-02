package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        helper(0, nums, new ArrayList<>(), subsets);

        return subsets;
    }

    public static void helper(int i, int[] nums, List<Integer> bf, List<List<Integer>> subsets) {
        if (i > nums.length - 1) {
            subsets.add(new ArrayList<>(bf));
            return;
        }

        bf.add(nums[i]);

        helper(i + 1, nums, new ArrayList<>(bf), subsets);

        bf.remove(bf.size() - 1);

        helper(i + 1, nums, new ArrayList<>(bf), subsets);
    }
}
