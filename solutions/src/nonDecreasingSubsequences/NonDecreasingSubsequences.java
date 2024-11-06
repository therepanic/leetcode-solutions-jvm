package nonDecreasingSubsequences;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        bypass(answer, new ArrayList<>(), nums, 0, Integer.MIN_VALUE);

        return answer;
    }

    public void bypass(List<List<Integer>> answer, List<Integer> current, int[] nums, int index, int prev) {
        if (index == nums.length) {
            if (current.size() > 1) {
                answer.add(new ArrayList<>(current));
            }
            return;
        }

        if (nums[index] >= prev) {
            current.add(nums[index]);

            bypass(answer, current, nums, index + 1, nums[index]);

            current.removeLast();
        }

        if (nums[index] == prev) {
            return;
        }

        bypass(answer, current, nums, index + 1, prev);
    }
}
