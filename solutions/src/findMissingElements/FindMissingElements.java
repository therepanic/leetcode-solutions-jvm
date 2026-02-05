package findMissingElements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> values = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            values.add(val);
            min = Math.min(val, min);
            max = Math.max(val, max);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = min ; i <= max; i++) {
            if (!values.contains(i)) {
                answer.add(i);
            }
        }
        return answer;
    }
}
