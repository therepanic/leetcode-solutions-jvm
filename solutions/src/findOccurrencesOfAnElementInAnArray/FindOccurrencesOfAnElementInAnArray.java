package findOccurrencesOfAnElementInAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOccurrencesOfAnElementInAnArray {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 1;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == x) {
                map.put(i, j);
                i++;
            }
        }

        int[] answer = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            answer[j] = map.getOrDefault(queries[j], -1);
        }
        return answer;
    }
}
