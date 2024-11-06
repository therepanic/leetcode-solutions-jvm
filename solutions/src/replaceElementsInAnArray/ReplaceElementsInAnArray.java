package replaceElementsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }

        for (int[] operation : operations) {
            int index = numIndexMap.get(operation[0]);

            nums[index] = operation[1];

            numIndexMap.remove(operation[0]);
            numIndexMap.put(operation[1], index);
        }

        return nums;
    }
}
