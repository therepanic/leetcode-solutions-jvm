package divideArrayIntoEqualPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
        Map<Integer, List<Integer>> iterationDividedNumListMap = new HashMap<>();

        for (int i : nums) {
            if (iterationDividedNumListMap.get(i) == null) {
                iterationDividedNumListMap.put(i, new ArrayList<>(List.of(i)));
            } else {
                List<Integer> dividedNumList = iterationDividedNumListMap.get(i);

                dividedNumList.add(i);

                iterationDividedNumListMap.put(i, dividedNumList);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : iterationDividedNumListMap.entrySet()) {
            if (entry.getValue().size() % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
