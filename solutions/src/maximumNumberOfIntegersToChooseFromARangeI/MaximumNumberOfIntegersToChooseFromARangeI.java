package maximumNumberOfIntegersToChooseFromARangeI;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromARangeI {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();

        for (int ban : banned) {
            bannedSet.add(ban);
        }

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (bannedSet.contains(num)) continue;

            sum += num;
            count++;

            if (sum > maxSum) {
                count--;
                break;
            } else if (sum == maxSum){
                break;
            }
        }

        return count;
    }
}
