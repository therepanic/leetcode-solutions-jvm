package findAllNumbersDisappearedInAnArrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArrayII {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int min = lower;
        for (int v : nums) {
            if (v < lower || v > upper) {
                continue;
            }
            if (min < v) {
                answer.add(List.of(min, v - 1));
            }
            min = Math.max(min, v + 1);
            if (min > upper) {
                break;
            }
        }
        if (min <= upper) {
            answer.add(List.of(min, upper));
        }
        return answer;
    }
}
