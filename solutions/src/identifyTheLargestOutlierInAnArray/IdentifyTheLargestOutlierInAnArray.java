package identifyTheLargestOutlierInAnArray;

import java.util.HashMap;
import java.util.Map;

public class IdentifyTheLargestOutlierInAnArray {

    public int getLargestOutlier(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            sum += num;
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int out = sum - num - num;
            if (numCountMap.getOrDefault(out, 0) > (out == num ? 1 : 0)) {
                answer = Math.max(out, answer);
            }
        }
        return answer;
    }

}
